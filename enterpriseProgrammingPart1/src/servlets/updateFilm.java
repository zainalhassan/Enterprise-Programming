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

@WebServlet("/updateFilm")
public class updateFilm extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		//initialise DAO;
		FilmDAO dao = new FilmDAO();
		//retrieve info about the desired film to update
		int filmID = Integer.parseInt(request.getParameter("filmID"));
		String filmName = request.getParameter("filmName");
		int filmYear = Integer.parseInt(request.getParameter("filmYear"));
		String  filmCredits = request.getParameter("filmCredits");
		int  filmDuration = Integer.parseInt(request.getParameter("filmDuration"));
		String  filmReview = request.getParameter("filmReview");
		//create a film object with user inputted data
		Film updatingFilm = new Film (filmID,filmName, filmYear, filmCredits,filmDuration, filmReview);
		//add 'filmToUpdate' to request
		request.setAttribute("filmToUpdate", updatingFilm);
		//updating of film to information user has inputted
		System.out.println(dao.updateFilm(updatingFilm));
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
