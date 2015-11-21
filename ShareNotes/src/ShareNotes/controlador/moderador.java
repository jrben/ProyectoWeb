package ShareNotes.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.jpa.Usuario;
import ShareNotes.modelo.servicio.ServicioPost;
import ShareNotes.modelo.servicio.ServicioUsuario;

/**
 * Servlet implementation class moderador
 */
@WebServlet("/moderador")
public class moderador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public moderador() {
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
		
		
        
        ServicioUsuario servicioU = new ServicioUsuario();
        
        List<Usuario> listaUsuarios=servicioU.listarUsuarios();
        
        request.setAttribute("usuarios", listaUsuarios);
       
        
        System.out.println("controldor lista " + listaUsuarios);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Moderador.jsp");
		rd.forward(request, response);
		
	}

}
