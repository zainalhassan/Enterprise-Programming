$(document).ready(function() 
{
	loadFilms();
	//set the header to Text
	document.getElementById("formatType").innerHTML = "All Films - TEXT";
	
	//display all films in text format
	$("#jsonFilms").hide();
	$("#jsonFilm").hide();
	$("#xmlFilms").hide();
	$("#xmlFilm").hide();
	
	//on click functions
    $("#searchButton").click(loadSearchedFilm);
    $("#confirm").click(loadDeleteFilm);
    $("#insertButton").click(loadInsertedFilm);
    $("#updateButton").click(loadUpdatedFilm);
    $("#jsonAllFilms").click(allJson);
    $("#TextAllFilms").click(showTextTable);
    $("#XmlAllFilms").click(allXml);
    $("#serchAttributeButton").click(loadSearchedFilmAttribute);
});

//This function will search for films with a desired attribute chosen by the user. This function also uses the LIKE operator for ease of search. 
function loadSearchedFilmAttribute()
{
	//displayed in the result div
	var resultRegion = "#result";
	//data retrieved stored in param object
	var param = 
	{
		searchAttribute: $("#chosenAttribute").val(),
		value: $("#inputtedInfo").val(),
		format: $("#chosenFormat").val()
	};
	
	console.log(param);
	//use of ajax to navigate to getFilmAttribute servlet. dependent on the format, different functions will be called
	$.ajax({url: "getFilmAttribute", data: param,success: function(response) { if(param.format == "json") { queryAllJson(response)
	}	else if (param.format == "text") { insertText(response, resultRegion);}
		else if(param.format == "xml") { showXmlTable2(response, resultRegion) }}, datatype: param.format});
	
	//refresh of films table
	var l = 0;
	for(l=0; l < 2; l++)
	{
		loadFilms();
	}
}

//used to insert text data into tables
function insertText(text, resultRegion) 
{	
	$(resultRegion).html(text);
}

//retrieves all films and upon success, inserts the text using insertText function into the allFilmsTable
function loadFilms()
{
	var resultRegion = "#allFilmsTable";
	
	$.ajax({url: "mainController", success: function(text) { insertText(text, resultRegion) } });
}

//retrieves a single film that upon success, uses param object, to use the function that is dependent on the format
function loadSearchedFilm()
{
	var resultRegion1 = "#result";
	var param = 
	{
		filmName: $("#searchInput").val(),
		format: $("#chosenFormat").val()
	};

	$("#jsonFilm").hide();
	$("#result").show();
	$("#xmlFilm").hide();
	
	$.ajax({url: "getFilmByName", data: param,success: function(response) { if(param.format == "json") { dealWithJSON(response)
	}	else if (param.format == "text") { insertText(response, resultRegion1);}
		else if(param.format == "xml") { showXmlTable2(response, resultRegion1) }}, datatype: param.format});
	
	var l = 0;
	for(l=0; l < 2; l++)
	{
		loadFilms();
	}
	
	//empty the search box after use and close the dialog
	document.getElementById('searchInput').value ="";
	$("#dialogSearch").dialog("close");
	
}

//retrieves a film that is deleted using param object, uses ajax to decide which function to run dependent on the function
function loadDeleteFilm()
{	
	var resultRegion2 = "#result";
	var param = 
	{
		filmID: $("#deleteInput").val(),
		format: $("#chosenFormat").val()
	};
	
	$("#jsonFilm").hide();
	$("#result").show();
	$("#xmlFilm").hide();
	
	$.ajax({url: "deleteFilm", data: param,success: function(response) { if(param.format == "json") { dealWithJSON(response)
	}	else if (param.format == "text") { insertText(response, resultRegion2);}
		else if(param.format == "xml") { showXmlTable2(response, resultRegion2) }}, datatype: param.format});
	
	
	var k = 0;
	for(k=0; k < 2; k++)
	{
		loadFilms();	
	}
	
	//empty the delete box after use and close the dialog
	document.getElementById('deleteInput').value ="";
	$("#dialogDelete").dialog("close");
	
}
//inserts a film using insertFilm servlet, param object, uses ajax and dependent on format, uses appropriate function.
function loadInsertedFilm()
{	
	var resultRegion3 = "#result";
	var param = { 
			filmName: $("#filmName").val(),
			filmYear: $("#filmYear").val(),
			filmDuration: $("#filmDuration").val(),
			filmCredits: $("#filmCredits").val(),
			filmReview: $("#filmReview").val(),
			format: $("#chosenFormat").val()
	};
	
	$("#jsonFilm").hide();
	$("#result").show();
	$("#xmlFilm").hide();
	
	$.ajax({url: "insertFilm", data: param,success: function(response) { if(param.format == "json") { dealWithJSON(response)
	}	else if (param.format == "text") { insertText(response, resultRegion3);}
		else if(param.format == "xml") { showXmlTable2(response, resultRegion3) }}, datatype: param.format});
	var i = 0;
	for(i=0; i < 2; i++)
	{
		loadFilms();
	}
	
	//empties the dialog inputs and closes dialog after use
	document.getElementById('filmName').value ="";
	document.getElementById('filmYear').value ="";
	document.getElementById('filmDuration').value ="";
	document.getElementById('filmCredits').value ="";
	document.getElementById('filmReview').value ="";
	
	$("#dialogInsert").dialog("close");
	
	
}

//uses param object and ajax to update a film, through the user chosen format
function loadUpdatedFilm()
{	
	var resultRegion4 = "#result";
	var param = { 
			filmID: $("#updateFilmID").val(),
			filmName: $("#updateFilmName").val(),
			filmYear: $("#updateFilmYear").val(),
			filmDuration: $("#updateFilmDuration").val(),
		    filmCredits: $("#updateFilmCredits").val(),
		    filmReview: $("#updateFilmReview").val(),
		    format: $("#chosenFormat").val()
		  };
	
	
	
	$("#jsonFilm").hide();
	$("#result").show();
	$("#xmlFilm").hide();
	
	$.ajax({url: "updateFilm", data: param,success: function(response) { if(param.format == "json") { dealWithJSON(response)
	}	else if (param.format == "text") { insertText(response, resultRegion4);}
		else if(param.format == "xml") { showXmlTable2(response, resultRegion4) }}, datatype: param.format});
	
	
	var j = 0;
	for(j=0; j < 2; j++)
	{
		loadFilms();
	}
	
	//empties the dialog inputs and closes the dialog
	document.getElementById('updateFilmID').value ="";
	document.getElementById('updateFilmName').value ="";
	document.getElementById('updateFilmYear').value ="";
	document.getElementById('updateFilmDuration').value ="";
	document.getElementById('updateFilmCredits').value ="";
	document.getElementById('updateFilmReview').value ="";
	
	$("#dialogUpdate").dialog("close");
	
	
}

//retrieves all films in json format, uses queryAllJson to display as table
function allJson()
{
	var resultRegion9 = "#jsonFilms";
	var format={
			format: "json"
	}
	$.ajax({url: "mainController?", data: format, success: function(text) 
		{ 
		if(format.format == "json") { queryAllJson(text, resultRegion9, format.format)
		}	else if (format.format == "text") { insertText(text, resultRegion9)}
			else if(format.format == "xml") { showXmlTable(text, resultRegion9) }}, datatype: format.format});
	
	loadFilms();
	loadFilms();
	loadFilms();
}

//retrieves all films in xml format, uses showXmlTable to display as table
function allXml()
{
	var resultRegion9 = "#xmlFilms";
	var format={
			format: "xml"
	}
	
	$.ajax({url: "mainController?", data: format, success: function(text) 
		{ 
		if(format.format == "json") { queryAllJson(text, resultRegion9, format.format)
		}	else if (format.format == "text") { insertText(text, resultRegion9)}
		else if(format.format == "xml") { showXmlTable(text, resultRegion9) }}, datatype: format.format});
	
	loadFilms();
	loadFilms();
	loadFilms();
}

//display Json data in a table
function queryAllJson(text)
{
	$("#jsonFilms").show();
	$("#allFilmsTable").hide();
	$("#xmlFilms").hide();
	
	document.getElementById("formatType").innerHTML = "All Films - JSON";
	
	$("#formatBody").empty();
	var tr;
    for (var i = 0; i < text.length; i++) {
        tr = $('<tr/>');
        tr.append("<td>" + text[i].FilmID + "</td>");
        tr.append("<td>" + text[i].FilmName + "</td>");
        tr.append("<td>" + text[i].FilmYear + "</td>");
        tr.append("<td>" + text[i].FilmCredits + "</td>");
        tr.append("<td>" + text[i].FilmDuration + "</td>");
        tr.append("<td>" + text[i].FilmReview + "</td>");
        $('#formatTable').append(tr);
    }
	
}

//when format text is selected for all films, the correct table is shown and others are hidden
function showTextTable()
{
	$("#jsonFilms").hide();
	$("#xmlFilms").hide();
	$("#allFilmsTable").show();
	
	document.getElementById("formatType").innerHTML = "All Films - Text";
}

//handles single json object and displays as a table
function dealWithJSON(text)
{
	$("#formatBodyJson").empty();
	
	$("#jsonFilm").show();
	$("#result").hide();
	$("#xmlFilm").hide();
	console.log("new one is this one");
	
	  var tr;
      tr = $('<tr/>');
      tr.append("<td>" + text.FilmID + "</td>");
      tr.append("<td>" + text.FilmName + "</td>");
      tr.append("<td>" + text.FilmYear + "</td>");
      tr.append("<td>" + text.FilmCredits + "</td>");
      tr.append("<td>" + text.FilmDuration + "</td>");
      tr.append("<td>" + text.FilmReview + "</td>");
      $("#formatJsonTable").append(tr);
      
}

//handles films retrieved in xml format and displays as a table
function showXmlTable(text, resultRegion)
{
	$("#jsonFilms").hide();
	$("#allFilmsTable").hide();
	$("#xmlFilms").show();
	
	document.getElementById("formatType").innerHTML = "All Films - XML";
	
	$("#formatBody1").empty();
	
	var films = text.getElementsByTagName("film");
	
	var rows = new Array();
    for(var i=0; i<films.length; i++) 
    {
      var film = films[i];
      var subElements = ["FilmID", "FilmName", "FilmYear", "FilmCredits", "FilmDuration", "FilmReview"];
      rows[i] = getElementValues(film, subElements);
      
      console.log(rows[i]);
      console.log(rows[i].length);
      
      var tr;
      tr = $('<tr/>');
      for(var b=0; b < rows[i].length; b++)
	  {
    	  console.log(rows[i][b]);
        tr.append("<td>" + rows[i][b] + "</td>");
        $('#formatTable1').append(tr);
	  }
    }
}


//handles films retrieved in xml format and displays as a table
function showXmlTable2(text, resultRegion)
{
	$("#jsonFilm").hide();
	$("#result").hide();
	$("#xmlFilm").show();
	
	document.getElementById("formatType").innerHTML = "All Films - XML";
	
	$("#formatBodyXml").empty();
	
	var films = text.getElementsByTagName("film");
	
	var rows = new Array();
    for(var i=0; i<films.length; i++) 
    {
      var film = films[i];
      var subElements = ["FilmID", "FilmName", "FilmYear", "FilmCredits", "FilmDuration", "FilmReview"];
      rows[i] = getElementValues(film, subElements);
      
      console.log(rows[i]);
      console.log(rows[i].length);
      
      var tr;
      tr = $('<tr/>');
      for(var b=0; b < rows[i].length; b++)
	  {
    	  console.log(rows[i][b]);
        tr.append("<td>" + rows[i][b] + "</td>");
        $('#formatXmlTable').append(tr);
	  }
    }
}



























