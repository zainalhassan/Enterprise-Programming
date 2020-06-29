<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.xml.bind.JAXBContext"%>
<%@ page import="javax.xml.bind.JAXBException"%>
<%@ page import="javax.xml.bind.Marshaller"%>
<%@ page import="models.Film"%>
<%@ page import="models.FilmList"%>
<%@ page import="java.util.*"%> 
<%@ page trimDirectiveWhitespaces="true"%>

<%
	FilmList films = new FilmList((List<Film>) request.getAttribute("film"));
	FilmList filmwithAttribute = new FilmList((List<Film>) request.getAttribute("getFilmAttribute"));
	Film searchedFilm = (Film)(request.getAttribute("searchedFilm"));
	Film filmToDelete = (Film)(request.getAttribute("filmToDelete"));
	Film filmToInsert = (Film) request.getAttribute("filmToInsert");
	Film filmToUpdate = (Film) request.getAttribute("filmToUpdate");
		
	if(request.getAttribute("film") != null)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(films, out);
		}
		catch(JAXBException je)
		{
			je.printStackTrace();
		}
	}
	else if(request.getAttribute("getFilmAttribute") != null)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(filmwithAttribute, out);
		}
		catch(JAXBException je)
		{
			je.printStackTrace();
		}
	}
	else if (request.getAttribute("searchedFilm") != null)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Film.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(searchedFilm, out);
		}
		catch(JAXBException je)
		{
			je.printStackTrace();
		}
	}
	else if (request.getAttribute("filmToDelete") != null)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Film.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(filmToDelete, out);
		}
		catch(JAXBException je)
		{
			je.printStackTrace();
		}
	}
	else if(filmToInsert != null)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Film.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(filmToInsert, out);
		}
		catch(JAXBException je)
		{
			je.printStackTrace();
		}
	}
	else if(filmToUpdate != null)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Film.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(filmToUpdate, out);
		}
		catch(JAXBException je)
		{
			je.printStackTrace();
		}
	}
%>