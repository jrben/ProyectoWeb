<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>nuevoPost</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<center>
		<h3>NUEVO POST</h3>
		<br><br>
		<h6>Ingrese los datos del Post:</h6>
		<br><br>
		<form action="">
		
		<table>
			<tr><th>
				Título:
			</th><td>	      
				<input type="text" name="titulo">
			</td></tr><tr><th>			
				Fecha:
			</th><td>      
				<input type="text" name="fecha">
			</td></tr><tr><th>	
				Descripción:
			</th><td>	      
				 <textarea name="Descripcion" rows="20" cols="60" id="txtDescripcion"></textarea>
			</td></tr><tr><th>
				Categoria:      
			</th><td>
				 <select name="comboCategoria" size="1" id="comboCategoria"  >
        <option selected="selected">              </option>
        <option>Sistemas Operativos</option>
        <option>Software</option>
        <option>Base de datos </option>
      </select>      
			</td></tr>
		</table>
		
		<button type="button" onclick="alert('Hello world!')">Guardar</button>
		
		</form>
	</center>
		<jsp:include page="footer.jsp" />
</body>
</html>