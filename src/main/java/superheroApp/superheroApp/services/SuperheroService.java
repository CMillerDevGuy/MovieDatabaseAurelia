package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.Superhero;
import superheroApp.superheroApp.servicesImpl.SuperheroServiceImpl.SuperheroException;



public interface SuperheroService {

	List<Superhero> getAllSuperheroes();

	public void addNewSuperhero(Superhero superhero) throws SuperheroException;

}
