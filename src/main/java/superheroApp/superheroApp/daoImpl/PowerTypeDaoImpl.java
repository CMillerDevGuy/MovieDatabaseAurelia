package superheroApp.superheroApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import superheroApp.superheroApp.daos.PowerTypeDao;
import superheroApp.superheroApp.entities.PowerType;


@Repository
@Transactional
public class PowerTypeDaoImpl implements PowerTypeDao{
	@PersistenceContext
	private EntityManager em;
	
	//sets up EntityManager for general hibernate functionality
	public void setEm(EntityManager em) 
	{
		this.em = em;
	}

	public List<PowerType> getAllPowerType() {
		return em.createQuery("SELECT p FROM PowerType p", PowerType.class).getResultList();
	}

	public void addPowerType(PowerType powerType) {
		em.merge(powerType);
	}
}
