<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<form action="">
		
		<table>
			<tr><td>
				Título:
			</td><td>	     
				<input type="text" name="titulo">
			</td><td>
				<button type="button" onclick="alert('Hello world!')">Buscar</button>
			</td></tr><tr><td>			
				Categoria:
			</td><td>      
				<select name="comboCategoria" size="1" id="comboCategoria"  >
                <option selected="selected">           </option>
                <option>Sistemas Operativos</option>
                 <option>Software</option>
                 
                 <option>Base de Datos</option>
                 </select>
			</td></tr><tr><td>	
				
		</table>
		
		<h3>Resultados</h3>
		
    <table width="500" border="1"  bgcolor="#FAFAFA" >
      <tr>
        <th width="153" bgcolor="#CFCDC8" scope="col">Título</th>
        <th width="301" bgcolor="#CFCDC8" scope="col">Descripción</th>
        
      </tr>
      <tr>
        <td ></td>
        <td ></td>
       
      </tr>
      <tr>
        <td ></td>
        <td></td>
       
      </tr>
      <tr>
        <td ></td>
        <td ></td>
      
      </tr>
      <tr>
        <td ></td>
        <td ></td>
     
      </tr>
     
    </table>
		
		</form>
	</center>
		<jsp:include page="footer.jsp" />

</body>
</html>