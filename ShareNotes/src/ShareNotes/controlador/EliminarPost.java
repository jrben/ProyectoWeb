package ShareNotes.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioDenuncia;
import ShareNotes.modelo.servicio.ServicioPost;


@WebServlet("/EliminarPost")
public class EliminarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminarPost() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPost=Integer.parseInt(request.getParameter("idPost"));
       
		//elimina las denuncias hacia el post
		ServicioDenuncia s = new ServicioDenuncia();
		s.eliminarDenuncia(idPost);
		
		//elimina el post
		ServicioPost servicio= new ServicioPost();
		servicio.eliminarPost(idPost);
		      
		request.setAttribute("mensaje", "Post eliminado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);		 
		
	}
}
