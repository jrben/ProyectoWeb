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

import ShareNotes.modelo.jpa.Denuncia;
import ShareNotes.modelo.servicio.ServicioDenuncia;


@WebServlet("/GuardarDenuncia")
public class GuardarDenuncia extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GuardarDenuncia() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Denuncia denuncia = new Denuncia();
		String motivoDenuncia=request.getParameter("motivo");
		motivoDenuncia = motivoDenuncia.replace("\r\n", "<br>");
		denuncia.setMotivo(motivoDenuncia);
		HttpSession session = request.getSession(true);
		denuncia.setIdUsuario((int)session.getAttribute("idUsuario"));

		
		ServicioDenuncia servicio = new ServicioDenuncia();
		servicio.ingresarDenuncia(denuncia);
		
		request.setAttribute("mensaje", "Denuncia ingresada correctamente, se procedera a verificarla!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);

	}

}
