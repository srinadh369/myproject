package com.mypack.DAO;

import java.util.Set;
import com.mypack.Beans.Film;


public interface FilmRepo {

	boolean addFilm(Film film);
	boolean removeFilm(String title);
	boolean modifyFilm(String title);
	Film searchFilmByTitle(String title);
	Set<Film> searchFilmByCategory(String categoryName);
	Set<Film> searchFilmByRating(byte rating);
	Set<Film> searchFilmByLanguage(String language);
	Set<Film> searchFilmByActor(String firstName,String lastName);
	Set<Film> getAllFilms();
}
