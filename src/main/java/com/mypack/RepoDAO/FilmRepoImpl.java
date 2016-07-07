package com.mypack.RepoDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.mypack.Beans.Actor;
import com.mypack.Beans.Film;
import com.mypack.DAO.FilmRepo;


public class FilmRepoImpl implements FilmRepo {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hello");
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();

	public boolean addFilm(Film film) {
		
		TypedQuery<Film> secondQuery=entityManager.createQuery("SELECT film FROM Film film",Film.class);
		List<Film> films=secondQuery.getResultList();
		
		for(Film filmsInDB:films){
			
			if(filmsInDB.getTitle().equals(film.getTitle()))
				return false;
		}
		
		TypedQuery<Actor> firstQuery=entityManager.createQuery("SELECT actor FROM Actor actor",Actor.class);
		List<Actor> actors=firstQuery.getResultList();
		Set<Actor> actorSet=new HashSet<Actor>();
		
		for(Actor actorFromUser:film.getActors()){
			boolean flag=false;
			Actor DBActor=null;
			for(Actor actorFromDB:actors){
				
				if(actorFromUser.getFirstName().equals(actorFromDB.getFirstName())&&actorFromUser.getLastName().equals(actorFromDB.getLastName())){
					System.out.println("if pass once");
					DBActor=actorFromDB;
					flag=true;
					break;
				}
				else{
					flag=false;
				}
			}
			if(flag){
				
				System.out.println("flag true scenario");
				actorSet.add(DBActor);
			}
			else{
				Actor newActor=new Actor();
				newActor=actorFromUser;
				newActor.getFilms().add(film);
				entityManager.getTransaction().begin();
				entityManager.persist(newActor);
				entityManager.getTransaction().commit();
				actorSet.add(newActor);
			}
		}
		film.getActors().clear();
		film.getActors().addAll(actorSet);
		entityManager.getTransaction().begin();
		entityManager.persist(film);
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean removeFilm(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyFilm(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	public Film searchFilmByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Film> searchFilmByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Film> searchFilmByRating(byte rating) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Film> searchFilmByLanguage(String language) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Film> searchFilmByActor(String firstName,String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Film> getAllFilms() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
