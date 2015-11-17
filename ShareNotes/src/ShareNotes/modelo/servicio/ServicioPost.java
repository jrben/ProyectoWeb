package ShareNotes.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ShareNotes.modelo.jpa.Categorias;
import ShareNotes.modelo.jpa.Post;

public class ServicioPost {
	
	public void ingresarPost(Post p){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
    	EntityManager em = emf.createEntityManager();
    	
    	em.getTransaction().begin();
    	Post post = new Post();
    	post.setIdUsuario(p.getIdUsuario());
    	post.setIdCategoria(p.getIdCategoria());
    	post.setTitulo(p.getTitulo());
    	post.setDescripcion(p.getDescripcion());
    	post.setFecha(p.getFecha());
    	em.persist(post);
		em.flush();
		em.getTransaction().commit();    	
	}
	
	public List<Post> listarPosts(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p");
		
		List<Post> posts = new ArrayList<Post>();
		List<Post> lista = (List<Post>)query.getResultList( );
		 for(Post p:lista){
			 Post post = new Post();
			 post.setTitulo(p.getTitulo());
			 post.setIdPost(p.getIdPost());
			 posts.add(post);
		 }	
		
		return posts;		
	}
	
	
	public List<Post> listarPostsCategoria(int id){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.idCategoria="+id);
		
		List<Post> posts = new ArrayList<Post>();
		List<Post> lista = (List<Post>)query.getResultList( );
		 for(Post p:lista){
			 Post post = new Post();
			 post.setTitulo(p.getTitulo());
			 post.setIdPost(p.getIdPost());
			 posts.add(post);
		 }	
		
		return posts;		
	}
	
	
public List<Post> listarPostsTitulo(String titulo){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.titulo= '"+titulo+"' ");
		
		List<Post> posts = new ArrayList<Post>();
		List<Post> lista = (List<Post>)query.getResultList( );
		 for(Post p:lista){
			 Post post = new Post();
			 post.setTitulo(p.getTitulo());
			 post.setIdPost(p.getIdPost());
			 posts.add(post);
			 
			 
		 }	
		
		 System.out.println("HOLA AMGO ROGER" +titulo+posts);
		return posts;		
	}
	
	
	
	public Post obtenerPost(int id){
		Post post = new Post();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "ShareNotes" );
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Post p WHERE p.idPost = " +id);
		
		post = (Post) query.getSingleResult();

		return post;
	}
	
	
	
	

}
