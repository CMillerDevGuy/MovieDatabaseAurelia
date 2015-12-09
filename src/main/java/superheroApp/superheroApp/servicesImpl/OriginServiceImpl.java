package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.OriginDao;
import superheroApp.superheroApp.entities.Origin;
import superheroApp.superheroApp.services.OriginService;


@Service
public class OriginServiceImpl implements OriginService{
	@Autowired
	OriginDao originDao;

	public List<Origin> getAllOrigin() {
		return originDao.getAllOrigin();
	}

	public boolean addOrigin(Origin origin) {
		originDao.addOrigin(origin);
		return true;
	}
}
