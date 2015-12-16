package superheroApp.superheroApp.daos;

import java.util.List;

import superheroApp.superheroApp.entities.PublicSupport;

public interface PublicSupportDao {

	List<PublicSupport> getAllPublicSupport();

	void addPublicSupport(PublicSupport publicSupport);

}
