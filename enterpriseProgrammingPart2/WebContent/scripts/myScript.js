
		
		function popUp() 
		{
			$.ajax({url: "randomNum.jsp", success: showAlert, cache: false});
		}
		
		function showAlert(text)
		{
			alert(text);
		}
		
		function load()
		{
			$("#h12").load("randomNum.jsp");
		}
		
		$(function()
		{
			$("#button2").click(popUp);
			$("#button3").click(load);
		});