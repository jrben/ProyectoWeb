<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ShareNotes.controlador.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<%@ include file="header.jsp" %>
<center>
	<h3>LOGIN</h3>
	<br>
	<br>
	<h6>Ingrese sus datos:</h6>
	<br>
	<br>
	<form action="Inicio" method="post">
		<table>
			<tr><td>Username:</td><td>       
				<input type="text" name="username">
			</td></tr><tr><td>Password:	</td><td>      
				<input type="password" name="password">
			</td></tr>
		</table>
			<button type="submit" name="botonLogin">Aceptar</button>
	</form>
	
	<h3><FONT COLOR="RED">
	<%if(request.getAttribute("error")!=null){%>
		<%=request.getAttribute("error")%>			
	<% } %>		
	</font>
	</h3>
	
</center>
	<jsp:include page="footer.jsp" />

</body>
</html>