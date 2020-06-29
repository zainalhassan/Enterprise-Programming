<%@ page language="java" contentType="text/json; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<%@ page import = "com.google.gson.Gson"%>
<%@ page import = "models.Film"%>  
<%@ page import = "java.util.List"%>

<%
Gson gson = new Gson();

List<Film> films = (List<Film>) request.getAttribute("film");
Film searchedFilm = (Film) request.getAttribute("searchedFilm");
List<Film> searchedAttribute = (List<Film>) request.getAttribute("getFilmAttribute");
Film filmToDelete = (Film) request.getAttribute("filmToDelete");
Film filmToInsert = (Film) request.getAttribute("filmToInsert");
Film filmToUpdate = (Film) request.getAttribute("filmToUpdate");
List<String> filmNames = (List<String>) request.getAttribute("filmNames");

if (films != null)
{
	String filmJson = gson.toJson(films);
	response.getWriter().println(filmJson);
}
else if (searchedFilm != null)
{
	System.out.println(searchedFilm);
	String searchedFilmJson = gson.toJson(searchedFilm);
	response.getWriter().println(searchedFilmJson);
}
else if (searchedAttribute != null)
{
	System.out.println(searchedAttribute);
	String searchedAttributeJson = gson.toJson(searchedAttribute);
	response.getWriter().println(searchedAttributeJson);
}
else if(filmToDelete != null)
{
	System.out.println(filmToDelete);
	String filmToDeleteJson = gson.toJson(filmToDelete);
	response.getWriter().println(filmToDeleteJson);
}
else if(filmToInsert != null)
{
	System.out.println(filmToInsert);
	String filmToInsertJson = gson.toJson(filmToInsert);
	response.getWriter().println(filmToInsertJson);
}
else if(filmToUpdate != null)
{
	System.out.println(filmToUpdate);
	String filmToUpdateJson = gson.toJson(filmToUpdate);
	response.getWriter().println(filmToUpdateJson);
}
else if(filmNames != null)
{
	System.out.println(filmNames);
	String filmNamesJson = gson.toJson(filmNames);
	response.getWriter().println(filmNamesJson);
}
%>