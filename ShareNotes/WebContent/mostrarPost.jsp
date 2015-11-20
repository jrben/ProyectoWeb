<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ShareNotes.modelo.jpa.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShareNotes</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	      <% System.setProperty("java.awt.headless", "false");%>
	
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
			
	<%if (session.getAttribute("username")!=null && request.getAttribute("nombreUsuarioPost")!=null){
		if (session.getAttribute("username").equals(request.getAttribute("nombreUsuarioPost")))
		{		
		%>
			<a href="EditarPost?idPost=<%=request.getAttribute("idPost")%>">Editar</a>	
			<br><a href="#" onclick="mensajeConfirmacion()">Eliminar</a>				
			
			<script>
			function mensajeConfirmacion() {	    
			    var respuesta = confirm("¿Estas seguro de eliminar el post?");
			    if (respuesta == true) {
			    	window.location="EliminarPost?idPost=<%=request.getAttribute("idPost")%>";
			    }
			}
			</script>
				
		<%}
		else{
		%>
			<a href="NuevaDenuncia?idPost=<%=request.getAttribute("idPost")%>">Denunciar post</a>
			<%if(session.getAttribute("mod")!=null){
				if(session.getAttribute("mod").equals("si")){
				%>
				<br><a href="#" onclick="mensajeConfirmacion()">Eliminar</a>				
				
				<script>
				function mensajeConfirmacion() {	    
				    var respuesta = confirm("¿Estas seguro de eliminar el post?");
				    if (respuesta == true) {
				    	window.location="EliminarPost?idPost=<%=request.getAttribute("idPost")%>";
				    }
				}
				</script>			
				<%}}%>
		<%}}
	else{
	%>
		<a href="NuevaDenuncia?idPost=<%=request.getAttribute("idPost")%>">Denunciar post</a>
	<%}%>
	<br>
	Categoría:  <%= request.getAttribute("nombreCategoriaPost") %><br>
	Creado por: <%= request.getAttribute("nombreUsuarioPost") %><br>
	<%= request.getAttribute("fechaPost") %><br>		
	</div>
	
	<br>
	<jsp:include page="footer.jsp" />
</body>
</html>