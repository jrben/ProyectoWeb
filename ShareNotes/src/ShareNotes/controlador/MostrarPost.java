package ShareNotes.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioPost;
import ShareNotes.modelo.servicio.ServicioUsuario;


@WebServlet("/MostrarPost")
public class MostrarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostrarPost() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post= new Post();
		ServicioPost servicio = new ServicioPost();

		post=servicio.obtenerPost(Integer.parseInt(request.getParameter("idPost")));
			
		int idUsuarioPost=post.getIdUsuario();
		ServicioUsuario s = new ServicioUsuario();
		String nombreUsuario=s.consultaUsuario(idUsuarioPost);
		request.setAttribute("nombreUsuarioPost", nombreUsuario);
		
		int idCategoriaPost=post.getIdCategoria();
		ServicioCategorias s1=new ServicioCategorias();
		String nombreCategoria=s1.consultaCategoria(idCategoriaPost);
		request.setAttribute("nombreCategoriaPost", nombreCategoria);
		
		String tituloPost=post.getTitulo();
		request.setAttribute("tituloPost", tituloPost);
		
		String descripcionPost=post.getDescripcion();
		request.setAttribute("descripcionPost", descripcionPost);
		
		String denunciarPost=post.getDenuncia();
		request.setAttribute("denunciarPost", denunciarPost);
		
		String fechaPost=post.getFecha();
		request.setAttribute("fechaPost", fechaPost);
	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrarPost.jsp");
		rd.forward(request, response);

	}

}
