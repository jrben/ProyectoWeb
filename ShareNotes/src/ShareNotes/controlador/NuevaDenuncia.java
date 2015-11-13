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

@WebServlet("/NuevaDenuncia")
public class NuevaDenuncia extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NuevaDenuncia() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevaDenuncia.jsp");
		rd.forward(request, response);
	}

}
