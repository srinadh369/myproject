package com.mypack.DAO;



import java.util.Set;
import com.mypack.Beans.Actor;


public interface ActorService {

	String createActor(Actor actor);
	String removeActor(String firstName,String lastName);
	String modifyActor(String firstName,String lastName);
	Actor searchActorByName(String firstName,String lastName);
	Set<Actor> getAllActors();
}
