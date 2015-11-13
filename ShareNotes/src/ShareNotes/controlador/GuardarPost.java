package ShareNotes.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioPost;


@WebServlet("/GuardarPost")
public class GuardarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuardarPost() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = new Post();
		post.setTitulo(request.getParameter("titulo"));
		String contenidoPost=request.getParameter("descripcion");
		contenidoPost = contenidoPost.replace("\r\n", "<br>");
		post.setDescripcion(contenidoPost);
		post.setFecha(new Date().toString());
		HttpSession session = request.getSession(true);
		post.setIdUsuario((int)session.getAttribute("idUsuario"));
		post.setIdCategoria(Integer.parseInt(request.getParameter("comboCategoria")));
		
		ServicioPost servicio = new ServicioPost();
		servicio.ingresarPost(post);
		
		request.setAttribute("mensaje", "Post ingresado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);
	}

}
