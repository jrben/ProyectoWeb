package ShareNotes.controlador;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShareNotes.modelo.jpa.Usuario;
import ShareNotes.modelo.servicio.ServicioUsuario;


@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inicio() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);	
		
		ServicioUsuario servicio = new ServicioUsuario();
		Usuario usuario = new Usuario();		

		usuario.setUsername(request.getParameter("username"));		
		
		int idUsuario=servicio.datosUsuario(request.getParameter("username"),request.getParameter("password"));
		//si los datos ingresados son correctos
		if(idUsuario>0){
			session.setAttribute("username", usuario.getUsername());
			session.setAttribute("idUsuario", idUsuario);
			if(servicio.esMod(request.getParameter("username"))==true){
				session.setAttribute("mod", "si");
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home");
			rd.forward(request, response);
		}
		//si los datos ingresados son incorrectos
		else
		{
			request.setAttribute("error","ERROR<br>Los datos ingresados son incorrectos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
		}

}
