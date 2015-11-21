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
import ShareNotes.modelo.jpa.Denuncia;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioDenuncia;

/**
 * Servlet implementation class NuevaCategoria
 */
@WebServlet("/NuevaCategoria")
public class NuevaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaCategoria() {
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
		// TODO Auto-generated method stub
		
		
		Categorias categoria= new Categorias();
		
        ServicioCategorias servicio = new ServicioCategorias();
		
        categoria.setNombreCategoria(request.getParameter("nombreCategoria"));
		
		servicio.ingresarCategoria(categoria);
		
		
		
		request.setAttribute("mensaje", "Categria ingresada correctamente, se procedera a verificarla!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);
		
		
	}

}
