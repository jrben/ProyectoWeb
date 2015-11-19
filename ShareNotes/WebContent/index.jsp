<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ShareNotes.modelo.jpa.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShareNotes</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<br>
	<div style="background-color:#eeeeff">
	<%if(request.getAttribute("NombCat")!=null){%>	
		<br>
		<h3>POSTS EN LA CATEGORIA <%=request.getAttribute("NombCat")%>:</h3>
		<br>	
	<% } 
	else{
	%>	
		<br>
		<h3>POSTS:</h3>
		<br>		
	<% } %>
	</div>
	
	
	<br>
	<h6>
	 <%
		
	    List<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
		for (int i=0;i<posts.size();i++)
		{	%>
			<div style="background-color:#F0F8FF"><br>						
			<a href="MostrarPost?idPost=<%=posts.get(i).getIdPost()%>">														
			<%=posts.get(i).getTitulo()%>
			</a>
			</div><br>				
			
		<%	}
	 %>
	</h6>	
	
	
	

	
	
	<jsp:include page="footer.jsp" />
</body>
</html>