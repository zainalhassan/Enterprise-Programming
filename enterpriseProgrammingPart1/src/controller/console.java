package controller;

import java.util.ArrayList;

import models.Film;
import models.FilmDAO;

public class console 
{

	public static void main(String[] args) 
	{
		FilmDAO dao = new FilmDAO();
		
//		System.out.println(dao.deleteFilm(6));
		
//		System.out.println(dao.getFilmByID(1));
		
		Film insertingFilm = new Film (0,"Jumanji 1", 2016, "Kevin Hart as long guy", 120, "Comedy");
//		System.out.println(dao.insertFilm(insertingFilm));
		
		Film updatingFilm = new Film (8,"Jumanji 3", 2020, "Kevin Hart as short guy", 120, "Comedy");
		System.out.println(dao.updateFilm(updatingFilm));
		
		ArrayList<Film> allFilms = dao.getAllFilms();
		
		for (Film f: allFilms)
		{
			System.out.println(f);
		}
	}
}
