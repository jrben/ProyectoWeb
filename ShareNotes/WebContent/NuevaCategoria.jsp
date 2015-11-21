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
		<h3>Nueva CATEGORIA</h3>
		<br><br>
		<h6>Ingrese los datos de Categoria:</h6>
		<br><br>
		<form action="NuevaCategoria" method="post">
					
		
		<table>
			<tr><td>
				Nombre:
			</td><td>	     
				<input type="text" name="nombreCategoria">
			</td><td>
				<button  type="submit" name="botonNuevaCategoria">Guardar</button>
			</td></tr><tr><td>			
							
		</table>

		</form>
	</center>
		<jsp:include page="footer.jsp" />
</body>
</html>