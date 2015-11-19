package ShareNotes.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioPost;


@WebServlet("/ActualizarPost")
public class ActualizarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ActualizarPost() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post=new Post();
		post.setIdPost(Integer.parseInt(request.getParameter("idP")));
		post.setTitulo((String) request.getParameter("titulo"));
		post.setIdCategoria(Integer.parseInt(request.getParameter("comboCategoria")));
		String contenidoPost = (String) request.getParameter("descripcion");
		contenidoPost = contenidoPost.replace("\r\n", "<br>");
		post.setDescripcion(contenidoPost);
		post.setFecha(new Date().toString());
		
		ServicioPost servicio=new ServicioPost();
		servicio.actualizarPost(post);
		
		request.setAttribute("mensaje", "Post actualizado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);
		
	}

}
