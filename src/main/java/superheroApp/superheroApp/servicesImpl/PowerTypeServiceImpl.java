package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.PowerTypeDao;
import superheroApp.superheroApp.entities.PowerType;
import superheroApp.superheroApp.services.PowerTypeService;



@Service
public class PowerTypeServiceImpl implements PowerTypeService{
	@Autowired
	PowerTypeDao powerTypeDao;

	public List<PowerType> getAllPowerType() {
		return powerTypeDao.getAllPowerType();
	}

	public boolean addPowerType(PowerType powerType) {
		powerTypeDao.addPowerType(powerType);
		return true;
	}
}