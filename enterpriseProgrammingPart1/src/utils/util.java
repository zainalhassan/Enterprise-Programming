package utils;

import javax.servlet.http.HttpServletResponse;

public class util 
{
	
	public static String util(HttpServletResponse response, String format)
	{
		String outputPage;
		
		if("xml".equals(format))
		{
			//if output is xml, then use films-xml.jsp 
			
			response.setContentType("text/xml");
			 outputPage = "/WEB-INF/results/film-xml.jsp";
		}
		else if("json".equals(format))
		{
			//if output is json, then use films-json.jsp 
			
			response.setContentType("text/json");
			 outputPage = "/WEB-INF/results/film-json.jsp";
		}
		else
		{
			//if output is text, then use films-text.jsp 
			
			response.setContentType("text/html");
			 outputPage = "/WEB-INF/results/film-text.jsp";
		}
		return outputPage;
	}
}
