package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.PowerType;


public interface PowerTypeService {

	List<PowerType> getAllPowerType();

	boolean addPowerType(PowerType powerType);

}