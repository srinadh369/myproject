package com.mypack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mypack.Beans.Actor;
import com.mypack.Beans.Album;
import com.mypack.Beans.Category;
import com.mypack.Beans.Film;
import com.mypack.Beans.Image;
import com.mypack.RepoDAO.FilmRepoImpl;
import com.mypack.ServiceDAO.FilmServiceImpl;


public class Test {
	
	public static void main(String[] args) {
		
		
		
		Actor actor1=new Actor();
		actor1.setCreateDate(new Date());
		actor1.setFirstName("Anusha anu");
		actor1.setLastName("Prabhas");
		actor1.setGender("Male");
		
		Album album2=new Album();
		album2.setCreateDate(new Date());
		album2.setAlbumName("Aslam's album");
		
		Image image3=new Image();
		image3.setImageURL("This is an image URL.");
		image3.setCreateDate(new Date());
		
		Image image4=new Image();
		image4.setImageURL("This is another Image URL");
		image4.setCreateDate(new Date());
		
		List<Image> images2=new ArrayList<Image>();
		images2.add(image3);
		images2.add(image4);
		
		album2.setImages(images2);
		
		actor1.setAlbum(album2);
	
		
		Film film=new Film();
		
		film.getActors().add(actor1);
		film.setCreateDate(new Date());
		film.setDescription("Am film description.");
		film.setLanguage("telugu");
		film.setLength((short)120);
		film.setRating((byte)5);
		film.setTitle("Bahubhali");
		film.setReleaseYear(new Date());
		
		Category category=new Category();
		category.setName("An epic");
		
		List<Category> categories=new ArrayList<Category>();
		categories.add(category);
		
		film.setCatgories(categories);
		
		film.getActors().add(actor1);
		actor1.getFilms().add(film);
			
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
//		
//		EntityManager em=emf.createEntityManager();
//		
		//em.getTransaction().begin();
//		
//		/*em.persist(image1);
//		em.persist(image2);
//		em.persist(image3);
//		em.persist(image4);*/
//		
//		/*em.persist(album);
//		em.persist(album2);*/
//		
//		//em.detach(actor1);
//		//em.merge(actor1);
//		
//		
//		
//		
//		//Session.evict(actor1);
//		
//		
//		
//		em.persist(film);
//		
//		em.getTransaction().commit();
	/*	
		Set<Actor> tempSet=new HashSet<Actor>();
		
		Actor fromDB=em.find(Actor.class, 1);
		Actor actor=new Actor();
		actor=fromDB;*/
		//actor.getFilms().add(film);
		//em.getTransaction().begin();
		//em.persist(actor);
		/*em.getTransaction().commit();
		tempSet.add(fromDB);*/
		
		/*film.getActors().clear();
		film.getActors().addAll(tempSet);*/
		//actor.getFilms().add(film);
		
		/*em.getTransaction().begin();*/
		
		/*em.persist(image1);
		em.persist(image2);
		em.persist(image3);
		em.persist(image4);*/
		
		/*em.persist(album);
		em.persist(album2);*/
		
		//em.detach(actor1);
		//em.merge(actor1);
		
		//System.out.println((new ActorServiceImpl(new ActorRepoImpl())).createActor(actor1));
		
		
//
		System.out.println((new FilmServiceImpl(new FilmRepoImpl())).createFilm(film));
//		
		
		//Session.evict(actor1);
		
		
		
		/*em.persist(film);
		
		em.getTransaction().commit();*/
	}
}
