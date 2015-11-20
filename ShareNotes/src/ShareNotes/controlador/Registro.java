package ShareNotes.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShareNotes.modelo.jpa.Usuario;
import ShareNotes.modelo.servicio.ServicioUsuario;


@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Registro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		if(request.getParameter("nombreUsuario").equals("")||request.getParameter("username").equals("") || request.getParameter("password1").equals("")){
			request.setAttribute("error","ERROR<br>Debe llenar todos los campos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
			rd.forward(request, response);
		}
		else{
			if(request.getParameter("password1").equals(request.getParameter("password2"))){ // comprueba si las contraseñas son iguales
				usuario.setUsername(request.getParameter("username"));
				usuario.setPassword(request.getParameter("password1"));
				usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
				ServicioUsuario s = new ServicioUsuario();
				if(s.ingresarUsuario(usuario)==true){ // si se ingreso el usuario a la bd
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
				else{ // si no se ingreso porque ya existe el mismo username con otro usuario
					request.setAttribute("error","ERROR<br>Ya existe otro usuario con el mismo username");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
					rd.forward(request, response);
				}
			}
			else{//contraseñas 1 y 2 no coinciden
				request.setAttribute("error","ERROR<br>Las contraseñas ingresadas no coinciden");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
