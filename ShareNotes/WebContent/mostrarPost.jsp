<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ShareNotes.modelo.jpa.*" %>
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
		<br>
		<h3><%= request.getAttribute("tituloPost") %></h3>
		<br>
	</div>
	<br>
	
	<div style="background-color:#ffffff">
	<br>			
	<%= request.getAttribute("descripcionPost") %><br>	
	</div>
	<br>
	<div style="background-color:#B39CB7">
		Denunciar Post:	<%=request.getAttribute("denunciarPost") %><br>
		Categoría:  <%= request.getAttribute("nombreCategoriaPost") %><br>
		Creado por: <%= request.getAttribute("nombreUsuarioPost") %><br>
		<%= request.getAttribute("fechaPost") %><br>		
	</div>
	
	<br>
	<jsp:include page="footer.jsp" />
</body>
</html>