package com.mypack.ServiceDAO;


import java.util.Set;

import com.mypack.Beans.Actor;
import com.mypack.DAO.ActorService;
import com.mypack.RepoDAO.ActorRepoImpl;


public class ActorServiceImpl implements ActorService {
	
	private ActorRepoImpl actorRepoImpl;
	

	public void setActorRepoImpl(ActorRepoImpl actorRepoImpl) {
		this.actorRepoImpl = actorRepoImpl;
	}

	public ActorServiceImpl() {
		super();
	}

	public ActorServiceImpl(ActorRepoImpl actorRepoImpl) {
		super();
		this.actorRepoImpl = actorRepoImpl;
	}

	public String createActor(Actor actor)  {

		if(actor.getFirstName()!=null && actor.getLastName()!=null && actor.getAlbum()!=null && actor.getFilms()!=null && actor.getGender()!=null){
		
				System.out.println("am in create actor method.");
				if(actorRepoImpl.addActor(actor))
				return "mission successful";
		}
		return null;
	}

	public String removeActor(String firstName, String lastName) {
		
		if(firstName!=null && lastName!=null){
			if(actorRepoImpl.removeActor(firstName, lastName))
			return "mission successful";
		}
		return null;
	}

	public String modifyActor(String firstName, String lastName) {
		
		if(firstName!=null && lastName!=null){
			if(actorRepoImpl.modifyActor(firstName, lastName))
			return "mission successful";
		}
		return null;
	}

	public Actor searchActorByName(String firstName, String lastName) {
		
		if(firstName!=null && lastName!=null){
			Actor actor=actorRepoImpl.searchActorByName(firstName, lastName);
			if(actor!=null)
			return actor;
		}
		return null;
	}

	public Set<Actor> getAllActors() {
		
		Set<Actor> actors=actorRepoImpl.getAllActors();
		if(actors!=null)
			return actors;
		return null;
	}

}
