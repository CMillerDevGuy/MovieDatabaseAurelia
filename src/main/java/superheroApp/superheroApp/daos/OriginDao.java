package superheroApp.superheroApp.daos;

import java.util.List;

import superheroApp.superheroApp.entities.Origin;

public interface OriginDao {

	List<Origin> getAllOrigin();

	void addOrigin(Origin origin);

}
