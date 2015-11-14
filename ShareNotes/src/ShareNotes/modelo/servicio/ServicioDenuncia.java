package ShareNotes.modelo.servicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Denuncia;

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
	
	
	
	

}