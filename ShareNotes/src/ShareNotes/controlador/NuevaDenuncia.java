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

@WebServlet("/NuevaDenuncia")
public class NuevaDenuncia extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NuevaDenuncia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);	

		
		
		ServicioPost servicio = new ServicioPost();
		Post post = new Post();
		post=servicio.obtenerPost(Integer.parseInt(request.getParameter("idPost")));
		request.setAttribute("titulo", post.getTitulo());
		request.setAttribute("idPost", post.getIdPost());
	

		if (session.getAttribute("username") != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevaDenuncia.jsp");
			rd.forward(request, response);	
		}else
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}
