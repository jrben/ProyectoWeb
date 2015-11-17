package ShareNotes.controlador;

import java.io.IOException;






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.servicio.ServicioCategorias;
import ShareNotes.modelo.servicio.ServicioPost;

import java.util.List;
/**
 * Servlet implementation class BuscarPost
 */
@WebServlet("/BuscarPost")
public class BuscarPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPost() {
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
		
		System.out.println("jaito pato"+request.getParameter("comboCategoria"));
		
		String titulo= request.getParameter("titulo");
		
		if(((request.getParameter("titulo").equals(""))&&((request.getParameter("comboCategoria")).equals(""))))
		{
		     // todos
		     ServicioPost servicio = new ServicioPost();
		     List<Post> listaPosts=servicio.listarPosts();		
		     request.setAttribute("posts", listaPosts);
		
		     
		}
		
		else
		{
		    //por titulo
		    if(titulo != " ")
		        {
		    	System.out.println("jaito pato 2 mmmmmmmm"+titulo);
		    	ServicioPost servicioTi = new ServicioPost();
		            List<Post> listaPostsTi=servicioTi.listarPostsTitulo("'titulo'");
		            request.setAttribute("posts", listaPostsTi);
		            System.out.println("listar prueba 2 titulo"+titulo+listaPostsTi);
		            
		        }
		
		//por categoria
		   if(((request.getParameter("comboCategoria")))!=null)
		    {
			   System.out.println("jaito pato 2 caaaat"+request.getParameter("comboCategoria")); 
		             ServicioPost servicioCa = new ServicioPost();
		             List<Post> listaPostsCa=servicioCa.listarPostsCategoria(Integer.parseInt(request.getParameter("comboCategoria")));
		              request.setAttribute("posts", listaPostsCa);
		     }
		
		}
		
		//System.out.println("hola"+ request.getParameter("titulo")+listaCategorias);	
		
		RequestDispatcher rd3 = getServletContext().getRequestDispatcher("/buscarPostTodos.jsp");
		rd3.forward(request, response);
		
		
	
			
		
	}

}
