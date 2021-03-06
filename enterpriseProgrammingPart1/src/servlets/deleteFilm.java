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

@WebServlet("/deleteFilm")
public class deleteFilm extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//initialise DAO;
		FilmDAO dao = new FilmDAO();
		//retrieve desired film id to delete
		int filmID = Integer.parseInt(request.getParameter("filmID"));
		//retrieve details about the desired film to delete
		Film filmToDelete = dao.getFilmByID(filmID);
		//add 'filmToDelete' to request, so can be used to display the desired film on front end
		request.setAttribute("filmToDelete", filmToDelete);
		//deletion of desired film
		System.out.println(dao.deleteFilm(filmID));
		
		//retrieve chosen format
		String format = request.getParameter("format");
		//use correct jsp page dependent on chosen format
		String outputPage = util.util(response, format);
		//send to correct page
		RequestDispatcher rd = request.getRequestDispatcher(outputPage);
		rd.include(request, response);
		
		
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
	
}
