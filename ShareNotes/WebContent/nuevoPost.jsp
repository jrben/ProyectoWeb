<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ShareNotes.modelo.jpa.*, java.util.*" %>
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
		<form action="GuardarPost" method="post">
		
		<table>
			<tr><th>
				Título:
			</th><td>	      
				<input type="text" name="titulo">
			</td></tr>
		
			<tr><th>	
				Descripción:
			</th><td>	      
				 <textarea name="descripcion" rows="20" cols="60"></textarea>
			</td></tr><tr><th>
				Categoria:      
			</th><td>
				 <select name="comboCategoria">
        			 <%
						List<Categorias> cat = (ArrayList<Categorias>) request.getAttribute("categorias");
						for (int i=0;i<cat.size();i++)
							{	%>
								<option value="<%=cat.get(i).getIdCategoria()%>"><%=cat.get(i).getNombreCategoria()%></option>
						<%	}
					 %>
      </select>      
			</td></tr>
		</table>
		
		<button type="submit" name="botonGuardarPost">Guardar</button>
		
		</form>
	</center>
		<jsp:include page="footer.jsp" />
</body>
</html>