package ShareNotes.modelo.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Post;
import ShareNotes.modelo.jpa.Usuario;


public class ServicioUsuario {

	public int datosUsuario(String username, String password)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = '"+username+"' AND u.password = '"+ password+"'");    	
    	if(query.getResultList().isEmpty())
    	{
    		return -1;
    	}
    	else
    	{
    		int id=-1;
    		List<Usuario> lista=(List<Usuario>)query.getResultList( );
    	    for( Usuario u:lista )
    	    {    	    	
    	    	id=u.getIdUsuario();
    	    }
    	    return id;
    	}    	    	
	}
	
	public boolean ingresarUsuario(Usuario usr){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	
    	if(existeUsuario(usr.getUsername())==false){
    		em.getTransaction().begin();
    		Usuario usuario = new Usuario();
    		usuario.setUsername(usr.getUsername());
    		usuario.setNombreUsuario(usr.getNombreUsuario());
    		usuario.setPassword(usr.getPassword());
    		usuario.setModerador(false);
    		em.persist(usuario);
    		em.flush();
    		em.getTransaction().commit();
    		return true;
    	}
    	else{
    		return false;
    	}
	}
	
	public boolean existeUsuario(String username)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = '"+username+"'");
    	if(query.getResultList().isEmpty())
    	{
    		return false;
    	}
    	else
    	{    	    
    	    return true;
    	}    	    	
	}
	
	public boolean esMod(String username)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = '"+username+"' AND u.moderador = 'TRUE'");    	
    	if(query.getResultList().isEmpty())
    	{
    		return false;
    	}
    	else
    	{
    	    return true;
    	}    	    	
	}
	
	public String consultaUsuario(int id){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = "+id);
    	Usuario u = (Usuario) query.getSingleResult();
    	String nombre=u.getNombreUsuario();
		return nombre;
	}
	
	
public List<Usuario> listarUsuarios() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM Usuario u");
		
		  System.out.println("consulta" + query);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Usuario> lista=(List<Usuario>)query.getResultList( );
	    for( Usuario u:lista )
	    {   
	    	Usuario usr = new Usuario();
	    	usr.setIdUsuario(u.getIdUsuario());
	    	usr.setNombreUsuario(u.getNombreUsuario());
	    //	usr.setModerador(u.isModerador());	    	
	    	usuarios.add(usr);
	    	
	    	
	    }
	    System.out.println("consulta" + usuarios);
	    return usuarios;		
	}
	
	
	
}
