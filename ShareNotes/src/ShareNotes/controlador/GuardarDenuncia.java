package ShareNotes.controlador;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShareNotes.modelo.jpa.Denuncia;
import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioDenuncia;
import ShareNotes.modelo.servicio.ServicioPost;


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
		
		//id usuario
		HttpSession session = request.getSession(true);
		denuncia.setIdUsuario((int)session.getAttribute("idUsuario"));
		//ID POST
	//aqui amigo Jairo
		
		denuncia.setIdPost((int)request.getAttribute("id"));
		
		//motivo
		String motivoDenuncia=request.getParameter("motivo");
		motivoDenuncia = motivoDenuncia.replace("\r\n", "<br>");
		denuncia.setMotivo(motivoDenuncia);
		
		ServicioDenuncia servicio = new ServicioDenuncia();
		servicio.ingresarDenuncia(denuncia);
		
		System.out.println(denuncia);
		
		request.setAttribute("mensaje", "Denuncia ingresada correctamente, se procedera a verificarla!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);

	}

}
