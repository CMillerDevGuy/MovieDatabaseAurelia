package superheroApp.superheroApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import superheroApp.superheroApp.daos.SuperheroDao;
import superheroApp.superheroApp.daos.SuperheroTeamDao;
import superheroApp.superheroApp.entities.SuperheroTeam;

@Repository
@Transactional
public class SuperheroTeamDaoImpl implements SuperheroTeamDao {
	@Autowired
	SuperheroDao superheroDao;
	
	@PersistenceContext
	private EntityManager em;
	
	//sets up EntityManager for general hibernate functionality
	public void setEm(EntityManager em) 
	{
		this.em = em;
	}

	
	public List<SuperheroTeam> getAllSuperherTeams() {
		return em.createQuery("SELECT e FROM SuperheroTeam e", SuperheroTeam.class).
				getResultList();
	}

	
	public void addNewSuperheroTeam(SuperheroTeam superheroTeam) {
		/*List<Superhero> superheroes = superheroTeam.getSuperheros();
		//superheroTeam.setSuperheros();
		for(Superhero s : superheroes){
			superheroDao.addNewSuperhero(s);
		}*/
		em.persist(superheroTeam);
	}


	public void updateSuperheroTeam(SuperheroTeam superheroTeam) {
		em.merge(superheroTeam);
	}


	public void deleteSuperheroTeam(SuperheroTeam superheroTeam) {
		em.remove(superheroTeam);
		
	}
}