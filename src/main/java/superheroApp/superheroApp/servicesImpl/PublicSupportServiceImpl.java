package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.PublicSupportDao;
import superheroApp.superheroApp.entities.PublicSupport;
import superheroApp.superheroApp.services.PublicSupportService;


@Service
public class PublicSupportServiceImpl implements PublicSupportService{
	@Autowired
	PublicSupportDao publicSupportDao;

	public List<PublicSupport> getAllPublicSupport() {
		return publicSupportDao.getAllPublicSupport();
	}

	public boolean addPublicSupport(PublicSupport publicSupport) {
 		publicSupportDao.addPublicSupport(publicSupport);
		return true;
	}
}
