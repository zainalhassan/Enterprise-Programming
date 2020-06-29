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


@WebServlet("/getFilmAttribute")
public class getFilmAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//initialise DAO;
		FilmDAO dao = new FilmDAO();
		
		//retrieve desired attribute to search with
		String searchAttribute = request.getParameter("searchAttribute");
		
		//retrieve desired format to search
		String searchValue = request.getParameter("value");
		//store matching films in an array list
		ArrayList<Film> allFilms = dao.getFilmAttribute(searchAttribute,searchValue);
		
		//add the matching films to the request
		request.setAttribute("getFilmAttribute", allFilms);
		//retrieve chosen format
		String format = request.getParameter("format");
		//use correct jsp page dependent on chosen format
		String outputPage = util.util(response, format);
		//send to correct page
		RequestDispatcher rd = request.getRequestDispatcher(outputPage);
		rd.include(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}