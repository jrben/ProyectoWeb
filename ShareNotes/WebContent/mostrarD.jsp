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
		
	</div>
	<br>
	
	<div style="background-color:#ffffff">
	<br>			
	<%= request.getAttribute("motivo") %><br>	
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>