package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Film;
import models.FilmDAO;
import utils.util;

@WebServlet("/getFilmByName")
public class getFilmByName extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//initialise DAO;
		FilmDAO dao = new FilmDAO();
		//retrieve desired film name to search
		String filmNameSearched = request.getParameter("filmName");
		//retreieval of data of desired film
		Film searchedFilm = dao.getFilmByName(filmNameSearched);
		System.out.println("Film searched for: " + searchedFilm);
		//add 'searchedFilm' to request
		request.setAttribute("searchedFilm", searchedFilm);
		//retrieve chosen format
		String format = request.getParameter("format");
		//use correct jsp page dependent on chosen format
		String outputPage = util.util(response, format);
		//send to correct page
		RequestDispatcher rd = request.getRequestDispatcher(outputPage);
		rd.include(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}