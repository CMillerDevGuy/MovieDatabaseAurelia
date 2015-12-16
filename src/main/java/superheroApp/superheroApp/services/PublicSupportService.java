package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.PublicSupport;

public interface PublicSupportService {

	List<PublicSupport> getAllPublicSupport();

	boolean addPublicSupport(PublicSupport publicSupport);

}