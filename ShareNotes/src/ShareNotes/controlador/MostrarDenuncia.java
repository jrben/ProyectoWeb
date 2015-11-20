package ShareNotes.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Denuncia;
import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioDenuncia;
import ShareNotes.modelo.servicio.ServicioPost;

@WebServlet("/MostrarDenuncia")
public class MostrarDenuncia extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MostrarDenuncia() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioDenuncia servicio = new ServicioDenuncia();
		List<Denuncia> listaDenuncias=servicio.listarDenuncias();
		request.setAttribute("denuncias", listaDenuncias);

		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrarDenuncia.jsp");
		rd.forward(request, response);

	}


}
