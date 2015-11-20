 <%@ page import="ShareNotes.modelo.jpa.*, java.util.*" %>
 <link href="CSS/estilos.css" media="all" rel="stylesheet" type="text/css" />
 <center>
    <h1 class="title">Share Notes</h1>
    <img src="./Imagenes/shareNotes.jpg" alt="ShareNotes" />
 </center>
<div>
					<%
						if (session.getAttribute("username") != null)
						{
							%>
							Bienvenido <%=session.getAttribute("username")%>
							Id <%=session.getAttribute("idUsuario")%>							
							<%
						}
					%> 
<nav>
 <ul class="menu">
  <li><a href="Home">Home</a></li>
  <%if(session.getAttribute("idUsuario")!=null){%>
  	<li><a href="NuevoPost">Crear Nuevo Post</a></li>  
  <% } %> 
  
  <li><a  href="#">Categorias</a>
    <ul class="sub-menu">
	<%
	List<Categorias> categorias = (ArrayList<Categorias>) session.getAttribute("listaCategorias");
	for (int i=0;i<categorias.size();i++)
	{	%>								
		<li> <a href="PostXcategoria?idCategoria=<%=categorias.get(i).getIdCategoria()%>"><%=categorias.get(i).getNombreCategoria()%></a></li>
	<%	}
	%> 

  	</ul>
  </li>
  <li><a  href="buscarPost.jsp"><i class="icon-user"></i>Buscar Post</a></li>
  <%if(session.getAttribute("mod")!=null){%>
  	<li><a href="mostrarDenuncia.jsp">Ver denuncias</a></li>

  	<li><a href="#">Administrar usuarios</a></li>  
  <% } %> 
  <li><a  href="#">Cuenta</a>
    <ul class="sub-menu">
    	<%if(session.getAttribute("idUsuario")!=null){%>
    			<li><a href="CerrarSesion">Cerrar sesion</a></li>
    	<% } 
    	else{
    	%>    	
	   		<li><a href="registro.jsp">Registrarse</a></li>
	   		<li><a href="login.jsp">Iniciar Sesion</a></li>
	   	<% } %>   	  		   
  	</ul>
  </li>
</ul>
</nav>

</div>
