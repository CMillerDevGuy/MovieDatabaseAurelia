package superheroApp.superheroApp.daos;

import java.util.List;

import superheroApp.superheroApp.entities.PowerType;

public interface PowerTypeDao {

	List<PowerType> getAllPowerType();

	void addPowerType(PowerType powerType);

}
