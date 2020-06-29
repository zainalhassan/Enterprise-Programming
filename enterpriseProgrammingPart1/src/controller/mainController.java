package controller;

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

@WebServlet("/mainController")
public class mainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//initialise DAO;
		FilmDAO dao = new FilmDAO();
		//store all films in an array list
		ArrayList<Film> allFilms = dao.getAllFilms();
		//add 'film' to request, used for displaying and editing films in front end
		request.setAttribute("film", allFilms);
		
		//retrieve chosen format
		String format = request.getParameter("format");
		//use correct jsp page dependent on chosen format
		String outputPage = util.util(response, format);
		
		//send to correct page
		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include(request, response);
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
}
