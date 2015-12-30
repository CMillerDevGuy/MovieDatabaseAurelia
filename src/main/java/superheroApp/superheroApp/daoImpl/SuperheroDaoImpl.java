package superheroApp.superheroApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import superheroApp.superheroApp.daos.SuperheroDao;
import superheroApp.superheroApp.entities.Superhero;

@Repository
@Transactional
public class SuperheroDaoImpl implements SuperheroDao {
	@PersistenceContext
	private EntityManager em;

	// sets up EntityManager for general hibernate functionality
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Superhero> getAllSuperheroes() {
		return em.createQuery("SELECT e FROM Superhero e", Superhero.class).getResultList();
	}

	public void addNewSuperhero(Superhero superhero) {
		em.merge(superhero);
	}

	public Superhero getSuperheroById(Integer id) {
		return em.createQuery("SELECT s FROM Superhero s WHERE s.superheroId = :superheroId", Superhero.class)
				.setParameter("superheroId", id).getSingleResult();
	}

	public List<Superhero> getSuperheroesNotOnTeam() {
		return em.createQuery("SELECT s FROM Superhero s WHERE s.onTeam = false", Superhero.class).getResultList();
	}

	public void updateSuperhero(Superhero s) {
		em.merge(s);
		
	}

	public List<Superhero> getSuperheroesNotTeamLeadAndNotOnTeam() {
		return em.createQuery("SELECT s FROM Superhero s WHERE s.onTeam = false AND s.teamLead = false", Superhero.class).getResultList();
	}
}