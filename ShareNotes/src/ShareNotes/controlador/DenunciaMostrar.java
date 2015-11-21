package ShareNotes.controlador;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Denuncia;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioDenuncia;
import ShareNotes.modelo.servicio.ServicioPost;
import ShareNotes.modelo.servicio.ServicioUsuario;

/**
 * Servlet implementation class Denuncia
 */
@WebServlet("/Denuncia")
public class DenunciaMostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenunciaMostrar() {
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
		Denuncia denuncia = new Denuncia();
		ServicioDenuncia servicio = new ServicioDenuncia();

		denuncia=servicio.obtenerDenuncia(Integer.parseInt(request.getParameter("idDenuncia")));
		request.setAttribute("idDenuncia", request.getParameter("idDenuncia"));
			
		
		
		
		String Descripcion=denuncia.getMotivo();
		request.setAttribute("motivo", Descripcion);
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrarD.jsp");
		rd.forward(request, response);
	}

}
