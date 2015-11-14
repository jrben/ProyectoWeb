<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ShareNotes.modelo.jpa.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<center>
		<h3>DENUNCIAR POST</h3>
		<br><br>
		<h5>TITULO: <%=request.getAttribute("titulo")%></h5>
		<p></p>
		<h5>Id: <%=request.getAttribute("id")%></h5>
		<p></p>
		<h6>Ingrese la Denuncia:</h6>
		<br><br>
		<form action="GuardarDenuncia" method="post">
		
		<table>
				
			<tr><th>	
				Motivo:
			</th><td>	      
				 <textarea name="motivo" rows="20" cols="30"></textarea>
			</td></tr><tr><th>
				Usuario:      
			</th><td>
				 <div>
					<%
						if (session.getAttribute("username") != null)
						{
							%>
							 <%=session.getAttribute("username")%>
							Id <%=session.getAttribute("idUsuario")%>
				
							<%
						}
					%> 

				</div>     
			</td></tr>
		</table>
		<button type="submit" name="botonGuardarDenuncia">Guardar</button>
	
		</form>
	</center>
		<jsp:include page="footer.jsp" />

</body>
</html>