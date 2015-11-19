package ShareNotes.controlador;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Denuncia denuncia= new Denuncia();
		ServicioDenuncia servicio = new ServicioDenuncia();

		denuncia=servicio.obtenerDenuncia(Integer.parseInt(request.getParameter("idDenuncia")));
		request.setAttribute("idDenuncia", request.getParameter("idDenuncia"));
		
		String motivo=denuncia.getMotivo();
		request.setAttribute("motivo", motivo);

	}


}
