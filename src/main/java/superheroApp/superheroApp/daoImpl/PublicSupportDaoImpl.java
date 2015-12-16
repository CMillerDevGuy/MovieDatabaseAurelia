package superheroApp.superheroApp.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import superheroApp.superheroApp.daos.PublicSupportDao;
import superheroApp.superheroApp.entities.PublicSupport;

@Repository
@Transactional
public class PublicSupportDaoImpl implements PublicSupportDao {
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<PublicSupport> getAllPublicSupport() {
		return em.createQuery("SELECT p FROM PublicSupport p", PublicSupport.class).getResultList();
	}

	public void addPublicSupport(PublicSupport publicSupport) {
		em.merge(publicSupport);
	}
}