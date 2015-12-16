package superheroApp.superheroApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import superheroApp.superheroApp.daos.OriginDao;
import superheroApp.superheroApp.entities.Origin;

@Repository
@Transactional
public class OriginDaoImpl implements OriginDao {
	@PersistenceContext
	private EntityManager em;

	// sets up EntityManager for general hibernate functionality
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Origin> getAllOrigin() {
		return em.createQuery("SELECT o FROM Origin o", Origin.class).getResultList();
	}

	public void addOrigin(Origin origin) {
		em.merge(origin);
	}
}
