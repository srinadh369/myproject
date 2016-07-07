package com.mypack.RepoDAO;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mypack.Beans.Actor;
import com.mypack.Beans.Film;
import com.mypack.DAO.ActorRepo;


public class ActorRepoImpl implements ActorRepo {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hello");
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	public boolean addActor(Actor actor)  {
		
		TypedQuery<Actor> firstQuery=entityManager.createQuery("SELECT actor FROM Actor actor",Actor.class);
		List<Actor> actors=firstQuery.getResultList();
	
		for(Actor actualActor:actors){
			
			if(actualActor.getFirstName().equals(actor.getFirstName()) && actualActor.getLastName().equals(actor.getLastName())){
				return false;				
			}		
		}
		
		TypedQuery<Film> secondQuery=entityManager.createQuery("SELECT film FROM Film film",Film.class);
		List<Film> films=secondQuery.getResultList();
		
		Set<Film> filmsSet=new HashSet<Film>();
	
		for(Film filmFromUser:actor.getFilms()){
			int flag=0;
			Film film=null;
			for(Film filmFromDB:films){
				
				if(filmFromDB.getTitle().equals(filmFromUser.getTitle())){
					film=filmFromDB;
					flag++;
					break;
				}
			}
			if(flag==0){
				return false;
			}
			else{
				film.getActors().add(actor);
				filmsSet.add(film);
			}
		}
		
		actor.getFilms().clear();
		actor.getFilms().addAll(filmsSet);
		entityManager.getTransaction().begin();
		entityManager.persist(actor);
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean removeActor(String firstName, String lastName) {
		
		int count=entityManager.createQuery("UPDATE Actor SET deleteDate='"+new Date()+"' where firstName='"+firstName+"' and lastName='"+lastName+"'", Actor.class).executeUpdate();
		if(count==0){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean modifyActor(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return false;
	}

	public Actor searchActorByName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
