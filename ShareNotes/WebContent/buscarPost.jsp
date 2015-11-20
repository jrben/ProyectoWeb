<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ page import="ShareNotes.modelo.jpa.*, java.util.*" %>
    <%@ page import="ShareNotes.controlador.*" %>
    <%@ page import="ShareNotes.modelo.servicio.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>buscarPost</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<center>
		<h3>Buscar POST</h3>
		<br><br>
		<h6>Ingrese los datos de Busqueda:</h6>
		<br><br>
		<form action="BuscarPost" method="post">
					
		
		<table>
			<tr><td>
				Título:
			</td><td>	     
				<input type="text" name="titulo">
			</td><td>
				<button  type="submit" name="botonBuscarPost">Buscar</button>
			</td></tr><tr><td>			
				Categoria:
			</td><td>      
				<select name="comboCategoria" size="1" >
				 <%
						List<Categorias> Categorias = (ArrayList<Categorias>) request.getAttribute("categorias");
						%>
				           <option value="">          </option>
						<%
						for (int i=0;i<categorias.size();i++)
							{	%>
								<option value="<%=categorias.get(i).getIdCategoria()%>"><%=categorias.get(i).getNombreCategoria()%></option>
						<%	}
					 %>
                
                 </select>


			</td></tr><tr><td>	
				
		</table>

		</form>
	</center>
		<jsp:include page="footer.jsp" />

</body>
</html>"