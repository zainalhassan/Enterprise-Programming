<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleFilmDAOProxyid" scope="session" class="models.FilmDAOProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleFilmDAOProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleFilmDAOProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleFilmDAOProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        models.FilmDAO getFilmDAO10mtemp = sampleFilmDAOProxyid.getFilmDAO();
if(getFilmDAO10mtemp == null){
%>
<%=getFilmDAO10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String filmID_2id=  request.getParameter("filmID20");
        int filmID_2idTemp  = Integer.parseInt(filmID_2id);
        String filmReview_3id=  request.getParameter("filmReview22");
            java.lang.String filmReview_3idTemp = null;
        if(!filmReview_3id.equals("")){
         filmReview_3idTemp  = filmReview_3id;
        }
        String filmName_4id=  request.getParameter("filmName24");
            java.lang.String filmName_4idTemp = null;
        if(!filmName_4id.equals("")){
         filmName_4idTemp  = filmName_4id;
        }
        String filmCredits_5id=  request.getParameter("filmCredits26");
            java.lang.String filmCredits_5idTemp = null;
        if(!filmCredits_5id.equals("")){
         filmCredits_5idTemp  = filmCredits_5id;
        }
        String filmYear_6id=  request.getParameter("filmYear28");
        int filmYear_6idTemp  = Integer.parseInt(filmYear_6id);
        String filmDuration_7id=  request.getParameter("filmDuration30");
        int filmDuration_7idTemp  = Integer.parseInt(filmDuration_7id);
        %>
        <jsp:useBean id="models1Film_1id" scope="session" class="models.Film" />
        <%
        models1Film_1id.setFilmID(filmID_2idTemp);
        models1Film_1id.setFilmReview(filmReview_3idTemp);
        models1Film_1id.setFilmName(filmName_4idTemp);
        models1Film_1id.setFilmCredits(filmCredits_5idTemp);
        models1Film_1id.setFilmYear(filmYear_6idTemp);
        models1Film_1id.setFilmDuration(filmDuration_7idTemp);
        boolean updateFilm15mtemp = sampleFilmDAOProxyid.updateFilm(models1Film_1id);
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateFilm15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
break;
case 32:
        gotMethod = true;
        String filmID_9id=  request.getParameter("filmID37");
        int filmID_9idTemp  = Integer.parseInt(filmID_9id);
        String filmReview_10id=  request.getParameter("filmReview39");
            java.lang.String filmReview_10idTemp = null;
        if(!filmReview_10id.equals("")){
         filmReview_10idTemp  = filmReview_10id;
        }
        String filmName_11id=  request.getParameter("filmName41");
            java.lang.String filmName_11idTemp = null;
        if(!filmName_11id.equals("")){
         filmName_11idTemp  = filmName_11id;
        }
        String filmCredits_12id=  request.getParameter("filmCredits43");
            java.lang.String filmCredits_12idTemp = null;
        if(!filmCredits_12id.equals("")){
         filmCredits_12idTemp  = filmCredits_12id;
        }
        String filmYear_13id=  request.getParameter("filmYear45");
        int filmYear_13idTemp  = Integer.parseInt(filmYear_13id);
        String filmDuration_14id=  request.getParameter("filmDuration47");
        int filmDuration_14idTemp  = Integer.parseInt(filmDuration_14id);
        %>
        <jsp:useBean id="models1Film_8id" scope="session" class="models.Film" />
        <%
        models1Film_8id.setFilmID(filmID_9idTemp);
        models1Film_8id.setFilmReview(filmReview_10idTemp);
        models1Film_8id.setFilmName(filmName_11idTemp);
        models1Film_8id.setFilmCredits(filmCredits_12idTemp);
        models1Film_8id.setFilmYear(filmYear_13idTemp);
        models1Film_8id.setFilmDuration(filmDuration_14idTemp);
        boolean insertFilm32mtemp = sampleFilmDAOProxyid.insertFilm(models1Film_8id);
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertFilm32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
break;
case 49:
        gotMethod = true;
        java.lang.String getAllFilms49mtemp = sampleFilmDAOProxyid.getAllFilms();
if(getAllFilms49mtemp == null){
%>
<%=getAllFilms49mtemp %>
<%
}else{
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllFilms49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
}
break;
case 52:
        gotMethod = true;
        String filmName_15id=  request.getParameter("filmName67");
            java.lang.String filmName_15idTemp = null;
        if(!filmName_15id.equals("")){
         filmName_15idTemp  = filmName_15id;
        }
        models.Film getFilmByName52mtemp = sampleFilmDAOProxyid.getFilmByName(filmName_15idTemp);
if(getFilmByName52mtemp == null){
%>
<%=getFilmByName52mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmID:</TD>
<TD>
<%
if(getFilmByName52mtemp != null){
%>
<%=getFilmByName52mtemp.getFilmID()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmReview:</TD>
<TD>
<%
if(getFilmByName52mtemp != null){
java.lang.String typefilmReview57 = getFilmByName52mtemp.getFilmReview();
        String tempResultfilmReview57 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmReview57));
        %>
        <%= tempResultfilmReview57 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmName:</TD>
<TD>
<%
if(getFilmByName52mtemp != null){
java.lang.String typefilmName59 = getFilmByName52mtemp.getFilmName();
        String tempResultfilmName59 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmName59));
        %>
        <%= tempResultfilmName59 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmCredits:</TD>
<TD>
<%
if(getFilmByName52mtemp != null){
java.lang.String typefilmCredits61 = getFilmByName52mtemp.getFilmCredits();
        String tempResultfilmCredits61 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmCredits61));
        %>
        <%= tempResultfilmCredits61 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmYear:</TD>
<TD>
<%
if(getFilmByName52mtemp != null){
%>
<%=getFilmByName52mtemp.getFilmYear()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmDuration:</TD>
<TD>
<%
if(getFilmByName52mtemp != null){
%>
<%=getFilmByName52mtemp.getFilmDuration()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 69:
        gotMethod = true;
        String filmID_16id=  request.getParameter("filmID72");
        int filmID_16idTemp  = Integer.parseInt(filmID_16id);
        boolean deleteFilm69mtemp = sampleFilmDAOProxyid.deleteFilm(filmID_16idTemp);
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteFilm69mtemp));
        %>
        <%= tempResultreturnp70 %>
        <%
break;
case 74:
        gotMethod = true;
        String filmID_17id=  request.getParameter("filmID89");
        int filmID_17idTemp  = Integer.parseInt(filmID_17id);
        models.Film getFilmByID74mtemp = sampleFilmDAOProxyid.getFilmByID(filmID_17idTemp);
if(getFilmByID74mtemp == null){
%>
<%=getFilmByID74mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmID:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
%>
<%=getFilmByID74mtemp.getFilmID()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmReview:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typefilmReview79 = getFilmByID74mtemp.getFilmReview();
        String tempResultfilmReview79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmReview79));
        %>
        <%= tempResultfilmReview79 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmName:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typefilmName81 = getFilmByID74mtemp.getFilmName();
        String tempResultfilmName81 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmName81));
        %>
        <%= tempResultfilmName81 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmCredits:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
java.lang.String typefilmCredits83 = getFilmByID74mtemp.getFilmCredits();
        String tempResultfilmCredits83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmCredits83));
        %>
        <%= tempResultfilmCredits83 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmYear:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
%>
<%=getFilmByID74mtemp.getFilmYear()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmDuration:</TD>
<TD>
<%
if(getFilmByID74mtemp != null){
%>
<%=getFilmByID74mtemp.getFilmDuration()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>