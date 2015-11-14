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
import ShareNotes.modelo.servicio.ServicioCategorias;


@WebServlet("/NuevoPost")
public class NuevoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NuevoPost() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServicioCategorias servicio = new ServicioCategorias();
		List<Categorias> listaCategorias=servicio.listarCategorias();
		request.setAttribute("categorias", listaCategorias);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoPost.jsp");
		rd.forward(request, response);
	}

}
