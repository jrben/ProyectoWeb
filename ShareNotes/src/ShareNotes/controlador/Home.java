package ShareNotes.controlador;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioPost servicio = new ServicioPost();
		List<Post> listaPosts=servicio.listarPosts();
		request.setAttribute("posts", listaPosts);
		
		ServicioCategorias s = new ServicioCategorias();
		List<Categorias> listaCategorias=s.listarCategorias();
		HttpSession session=request.getSession(true);	
		session.setAttribute("listaCategorias", listaCategorias);
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
