package ShareNotes.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Denuncia;
import ShareNotes.modelo.jpa.Post;

public class ServicioDenuncia {
	public void ingresarDenuncia(Denuncia d){
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	Denuncia denuncia = new Denuncia();
    	denuncia.setIdPost(d.getIdPost());
    	denuncia.setIdUsuario(d.getIdUsuario());
    	denuncia.setMotivo(d.getMotivo());
    	em.persist(denuncia);
		em.flush();
		em.getTransaction().commit();    	
	}
	
	//elimina denuncias dado el id del Post
	public void eliminarDenuncia(int idPost)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	Query query = em.createQuery("SELECT d FROM Denuncia d WHERE d.idPost="+idPost);
    	
		List<Denuncia> lista = (List<Denuncia>)query.getResultList( );
		 for(Denuncia d:lista){			 
			 Denuncia denuncia = em.find(Denuncia.class, d.getIdDenuncia());				 
			 em.getTransaction().begin();
			 em.remove(denuncia);
			 em.getTransaction().commit();
		 }   	
		
	}
	
	public Denuncia obtenerDenuncia(int id){
		Denuncia denuncia = new Denuncia();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT d FROM Denuncia d WHERE d.idDenuncia = " +id);
		
		denuncia = (Denuncia) query.getSingleResult();

		return denuncia;
	}
	
	

}
