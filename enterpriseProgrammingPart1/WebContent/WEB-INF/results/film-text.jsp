<%@ page import = "models.Film"%>
<%@ page import = "java.util.ArrayList"%>
    
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Film</title>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> >

</head>
<body>
	<c:choose>
	<c:when test="${!empty filmNames}">	
		${filmNames}
	</c:when>
	<c:otherwise>
    <table class="table table-borderless table-dark">
		<thead class="thead-light">
		<tr>
			<th scope="col">Film Id</th>
			<th scope="col">Film Name</th>
			<th scope="col">Film Year</th>
			<th scope="col">Film Duration</th>
			<th scope="col">Film Credits</th>
			<th scope="col">Film Reviews</th>
		</tr>
	
		<c:forEach items ="${film}" var="c">
		
			<tr>
				<td>${c.getFilmID()}</td>
				<td>${c.getFilmName()}</td>
				<td>${c.getFilmYear()}</td>
				<td>${c.getFilmDuration()}</td>
				<td>${c.getFilmCredits()}</td>
				<td>${c.getFilmReview()}</td>
			</tr>
		</c:forEach>
         </c:otherwise>
	</c:choose>
		<c:choose>
	   		<c:when test="${!empty searchedFilm}">
				<tr>
					<td>${searchedFilm.getFilmID()}</td>
					<td>${searchedFilm.getFilmName()}</td>
					<td>${searchedFilm.getFilmYear()}</td>
					<td>${searchedFilm.getFilmDuration()}</td>
					<td>${searchedFilm.getFilmCredits()}</td>
					<td>${searchedFilm.getFilmReview()}</td>
				</tr>
			</c:when>
		
	   		<c:when test="${!empty filmToDelete}">
				<tr>
					<td>${filmToDelete.getFilmID()}</td>
					<td>${filmToDelete.getFilmName()}</td>
					<td>${filmToDelete.getFilmYear()}</td>
					<td>${filmToDelete.getFilmDuration()}</td>
					<td>${filmToDelete.getFilmCredits()}</td>
					<td>${filmToDelete.getFilmReview()}</td>
				</tr>
			</c:when>
			
	   		<c:when test="${!empty filmToInsert}">
				<tr>
					<td>${filmToInsert.getFilmID()}</td>
					<td>${filmToInsert.getFilmName()}</td>
					<td>${filmToInsert.getFilmYear()}</td>
					<td>${filmToInsert.getFilmDuration()}</td>
					<td>${filmToInsert.getFilmCredits()}</td>
					<td>${filmToInsert.getFilmReview()}</td>
				</tr>
			</c:when>
			
	   		<c:when test="${!empty filmToUpdate}">
				<tr>
					<td>${filmToUpdate.getFilmID()}</td>
					<td>${filmToUpdate.getFilmName()}</td>
					<td>${filmToUpdate.getFilmYear()}</td>
					<td>${filmToUpdate.getFilmDuration()}</td>
					<td>${filmToUpdate.getFilmCredits()}</td>
					<td>${filmToUpdate.getFilmReview()}</td>
				</tr>
			</c:when>
		
		
		<c:when test="${!empty getFilmAttribute}">
		<c:forEach items ="${getFilmAttribute}" var="f">
		
			<tr>
				<td>${f.getFilmID()}</td>
				<td>${f.getFilmName()}</td>
				<td>${f.getFilmYear()}</td>
				<td>${f.getFilmDuration()}</td>
				<td>${f.getFilmCredits()}</td>
				<td>${f.getFilmReview()}</td>
			</tr>
		</c:forEach>
			</c:when>
		</c:choose>
	
	</table>
	
<br>

</body>
</html>