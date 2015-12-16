package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.Power;
import superheroApp.superheroApp.validation.PowerValidation.PowerException;

public interface PowerService {

	List<Power> getAllPowers();

	void addPower(Power power) throws PowerException;

	void updatePower(Power power);

}
