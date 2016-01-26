package superheroApp.superheroApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import superheroApp.superheroApp.daos.MovieDao;
import superheroApp.superheroApp.entities.Movie;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {
	@PersistenceContext
	private EntityManager em;

	// sets up EntityManager for general hibernate functionality
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Movie> getAllMovies() {
		return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
	}

	public void updateMovie(Movie movie) {
		em.merge(movie);
		
	}

	public Movie getMovieById(int id) {
		return em.createQuery("SELECT m FROM Movie m WHERE m.id = :id", Movie.class).setParameter("id", id).getSingleResult();
	}

	public void createMovie(Movie movie) {
		em.merge(movie);
		
	}

	public void delete(int id) {
		Movie movie = getMovieById(id);
		
		em.remove(movie);	
	}
}
