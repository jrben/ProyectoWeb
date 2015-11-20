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
		System.out.println("11111");
		//id usuario
		HttpSession session = request.getSession(true);
		denuncia.setIdUsuario((int)session.getAttribute("idUsuario"));
		System.out.println("222222");
		denuncia.setIdPost(Integer.parseInt(( request.getParameter("idd"))));
		System.out.println("444444");
		//motivo
		String motivoDenuncia=(String) request.getParameter("motivo");
		motivoDenuncia = motivoDenuncia.replace("\r\n", "<br>");
		denuncia.setMotivo(motivoDenuncia);
		System.out.println("3333333");
		System.out.println("holaa"+denuncia.getMotivo()+denuncia.getIdPost()+denuncia.getIdUsuario());
		ServicioDenuncia servicio = new ServicioDenuncia();
		
		servicio.ingresarDenuncia(denuncia);
		
		System.out.println("holaa"+denuncia.getMotivo()+denuncia.getIdPost()+denuncia.getIdUsuario());
		
		request.setAttribute("mensaje", "Denuncia ingresada correctamente, se procedera a verificarla!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);

	}

}
