package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.PowerDao;
import superheroApp.superheroApp.entities.Power;
import superheroApp.superheroApp.services.PowerService;
import superheroApp.superheroApp.validation.PowerValidation;
import superheroApp.superheroApp.validation.PowerValidation.PowerException;

@Service
public class PowerServiceImpl implements PowerService {
	@Autowired
	PowerDao powerDao;

	@Autowired
	PowerValidation powerValidation;

	public List<Power> getAllPowers() {
		return powerDao.getAllPowers();
	}

	public void addPower(Power power) throws PowerException {
		if (powerValidation.validatePower(power)) {
			powerDao.addPower(power);
		}
	}

	public void updatePower(Power power) {
		powerDao.updatePower(power);

	}

	public Power getSinglePower() {
		return powerDao.getSinglePower();
	}

}
