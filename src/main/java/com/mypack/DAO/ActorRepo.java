package com.mypack.DAO;

import java.sql.SQLException;
import java.util.Set;
import com.mypack.Beans.Actor;


public interface ActorRepo {

	boolean addActor(Actor actor) throws SQLException;
	boolean removeActor(String firstName,String lastName);
	boolean modifyActor(String firstName,String lastName);
	Actor searchActorByName(String firstName,String lastName);
	Set<Actor> getAllActors();
}
