<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<center>
		<h3>Administración de Usuarios</h3>
		<br><br>
		<h6>Ingrese los datos para Cambiar de Usuario a Moderador:</h6>
		<br><br>
		<form action="NuevaCategoria" method="post">
					
		
		<table>
			<tr><td>
				Usuarios:
			</td><td>	     
				<input type="text" name="nombreCategoria">
			</td><td>
				<button  type="submit" name="botonNuevaCategoria">Cambiar</button>
			</td></tr><tr><td>			
							
		</table>
</body>
</html>