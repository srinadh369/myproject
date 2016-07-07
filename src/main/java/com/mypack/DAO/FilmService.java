package com.mypack.DAO;

import java.util.Set;
import com.mypack.Beans.Film;

public interface FilmService {
	String createFilm(Film film);
	String removeFilm(String title);
	String modifyFilm(String title);
	Film searchFilmByTitle(String title);
	Set<Film> searchFilmByCategory(String categoryName);
	Set<Film> searchFilmByRating(byte rating);
	Set<Film> searchFilmByLanguage(String language);
	Set<Film> searchFilmByActor(String firstNmae, String lastName);
	Set<Film> getAllFilms();
	}
