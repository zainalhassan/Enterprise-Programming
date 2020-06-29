$(document).ready(function() {
$(function() {
$("#dialogInsert").dialog({
autoOpen: false
});

$("#dialogUpdate").dialog({
	autoOpen: false
	});

$("#dialogDelete").dialog({
	autoOpen: false
	});

$("#dialogSearch").dialog({
	autoOpen: false
	});

$("#deleteConfirmDialog").dialog({
	autoOpen: false
	});

$("#dialogSearchAttribute").dialog({
	autoOpen: false
	});


$("#searchFilm").on("click", function() {
	$("#dialogSearch").dialog("open");
	$("#dialogUpdate").dialog("close");
	$("#dialogDelete").dialog("close");
	$("#dialogInsert").dialog("close");
	$("#dialogSearchAttribute").dialog("close");
	});


$("#searchFilmWithAttribute").on("click", function() {
	
$("#dialogSearchAttribute").dialog("open");
$("#dialogUpdate").dialog("close");
$("#dialogDelete").dialog("close");
$("#dialogInsert").dialog("close");
$("#dialogSearch").dialog("close");
});

$("#deleteFilm").on("click", function() {
	$("#dialogDelete").dialog("open");
	$("dialogSearch").dialog("close");
	$("#dialogInsert").dialog("close");
	$("#dialogUpdate").dialog("close");
	$("#dialogSearchAttribute").dialog("close");
	});

$("#deleteButton").on("click", function() {
	if( document.getElementById('deleteInput').value !="")
		{
			$("#deleteConfirmDialog").dialog("open");
		}

	});

$("#cancel").on("click", function() {
	$("#deleteConfirmDialog").dialog("close");
	});

$("#confirm").on("click", function() {
	$("#deleteConfirmDialog").dialog("close");
	});


$("#insertFilm").on("click", function() {
	$("#dialogInsert").dialog("open");
	$("#dialogUpdate").dialog("close");
	$("#dialogDelete").dialog("close");
	$("#dialogSearch").dialog("close");
	$("#dialogSearchAttribute").dialog("close");
	});

$("#updateFilm").on("click", function() {
	$("#dialogUpdate").dialog("open");
	$("#dialogDelete").dialog("close");
	$("#dialogSearch").dialog("close");
	$("#dialogInsert").dialog("close");
	$("#dialogSearchAttribute").dialog("close");
	});

});


});