package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.Origin;


public interface OriginService {

	List<Origin> getAllOrigin();

	boolean addOrigin(Origin origin);

}
