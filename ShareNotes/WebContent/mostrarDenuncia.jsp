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
		<h3>DENUNCIAS</h3>
		<br>
	</div>
	<br>
	
	<div style="background-color:#ffffff">
	 <%
		
	    List<Denuncia> denuncias = (ArrayList<Denuncia>) request.getAttribute("denuncias");
		for (int i=0;i<denuncias.size();i++)
		{	%>
			<div style="background-color:#F0F8FF"><br>						
			<a href="MostrarDenuncia?idDenuncia=<%=denuncias.get(i).getIdDenuncia()%>">														
			Denuncia Nro <%=i%><%=denuncias.get(i).getIdDenuncia()%>
			
			</a>
			</div><br>				
			
		<%	}
	 %>

	</div>
	<br>
	<jsp:include page="footer.jsp" />
</body>
</html>