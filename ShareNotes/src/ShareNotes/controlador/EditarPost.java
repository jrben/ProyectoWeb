package ShareNotes.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioPost;


@WebServlet("/EditarPost")
public class EditarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditarPost() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioPost servicio = new ServicioPost();
		Post post = new Post();
		post=servicio.obtenerPost(Integer.parseInt(request.getParameter("idPost")));
		request.setAttribute("tituloPost", post.getTitulo());
		
		ServicioCategorias s = new ServicioCategorias();
		List<Categorias> listaCategorias=s.listarCategorias();		
		request.setAttribute("categorias", listaCategorias);	
		
		
		String contenido=post.getDescripcion();
		contenido = contenido.replace("<br>","\r\n");
		request.setAttribute("contenidoPost", contenido);
		
		request.setAttribute("idP", post.getIdPost());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/editarPost.jsp");
		rd.forward(request, response);
	}

}
