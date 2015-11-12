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
  <li><a href="index.jsp">Home</a></li>
  <%if(session.getAttribute("idUsuario")!=null){%>
  	<li><a href="nuevoPost.jsp">Crear Nuevo Post</a></li>  
  <% } %> 
  
  <li><a  href="#">Categorias</a>
    <ul class="sub-menu">
   		<li><a href="#">Categoria 1</a></li>
   		<li><a href="#">Categoria 2</a></li>
   		<li><a href="#">Categoria 3</a></li>
   		<li><a href="#">Categoria 4</a></li>   
  	</ul>
  </li>
  <li><a  href="buscarPost.jsp"><i class="icon-user"></i>Buscar Post</a></li>
  <%if(session.getAttribute("mod")!=null){%>
  	<li><a href="#">Ver denuncias</a></li>
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
