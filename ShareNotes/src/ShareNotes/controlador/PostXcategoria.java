package ShareNotes.controlador;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioPost;


@WebServlet("/PostXcategoria")
public class PostXcategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostXcategoria() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioPost servicio = new ServicioPost();
		List<Post> listaPosts=servicio.listarPostsCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		request.setAttribute("posts", listaPosts);
		
		ServicioCategorias s = new ServicioCategorias();
		String nombreCategoria=s.consultaCategoria(Integer.parseInt(request.getParameter("idCategoria"))).toUpperCase();				
		request.setAttribute("NombCat",nombreCategoria);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
