package ShareNotes.controlador;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioPost;

import java.util.List;
/**
 * Servlet implementation class BuscarPost
 */
@WebServlet("/BuscarPost")
public class BuscarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioPost servicio = new ServicioPost();
		List<Post> listaPosts=servicio.listarPosts();
		request.setAttribute("posts", listaPosts);
		
		ServicioCategorias s = new ServicioCategorias();
		List<Categorias> listaCategorias=s.listarCategorias();
		
		HttpSession session=request.getSession(true);	
		session.setAttribute("listaCategorias", listaCategorias);
		
		
		RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/buscarPostTodos.jsp");
		rd3.forward(request, response);
		
		
	
			
		
	}

}
