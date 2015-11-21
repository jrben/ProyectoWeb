<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
  <%@ page import="ShareNotes.modelo.jpa.*, java.util.*" %>
    <%@ page import="ShareNotes.controlador.*" %>
    <%@ page import="ShareNotes.modelo.servicio.*" %>
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
		<form action="moderador" method="post">	
		
		<table>
			<tr><td>
				Usuarios:
			</td><td>	     
				
				<select name="comboUsuario" size="1" id="comboUsuario" >
				 
					<OPTION VALUE="link pagina 1">opcion1</OPTION>	
					
					
						<%List<Usuario> usuario = (ArrayList<Usuario>) request.getAttribute("usuarios");
						%>
				           <option value="">          </option>
						<%
						for (int i=0;i<usuario.size();i++)
							{	%>
								<option value="<%=usuario.get(i).getIdUsuario()%>"><%=usuario.get(i).getNombreUsuario()%></option>
						<%	}
					 %>
                
                 </select>
				
			</td><td>
			
				
			</td></tr><tr><td>			
			
			
							
		</table>
</body>
</html>