package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.Power;
import superheroApp.superheroApp.servicesImpl.PowerServiceImpl.PowerException;


public interface PowerService {

	List<Power> getAllPowers();

	boolean addPower(Power power) throws PowerException;

	void updatePower(Power power);

}

