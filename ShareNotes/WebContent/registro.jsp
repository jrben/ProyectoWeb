<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registro</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<center>
		<h3>REGISTRO</h3>
		<br><br>
		<h6>Ingrese sus datos:</h6>
		<br><br>
		<form action="Registro" method="post">		
		<table>
			<tr><td>
				Nombre:
			</td><td>	      
				<input type="text" name="nombreUsuario">
			</td></tr><tr><td>			
				Username:
			</td><td>      
				<input type="text" name="username">
			</td></tr><tr><td>	
				Password:
			</td><td>	      
				<input type="password" name="password1">
			</td></tr><tr><td>
				Repetir password:      
			</td><td>
				<input type="password" name="password2">
			</td></tr>
		</table>
		
		<button type="submit" name="botonRegistrarme">Registrarme</button>
				
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