package superheroApp.superheroApp.daos;

import java.util.List;

import superheroApp.superheroApp.entities.Power;

public interface PowerDao {

	List<Power> getAllPowers();

	void addPower(Power power);

	void updatePower(Power power);

	Power getSinglePower();

}