package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.Superhero;
import superheroApp.superheroApp.validation.SuperheroValidation.SuperheroException;

public interface SuperheroService {

	List<Superhero> getAllSuperheroes();

	public void addNewSuperhero(Superhero superhero) throws SuperheroException;

	Superhero getSuperheroById(Integer id);

	List<Superhero> getSuperheroesNotOnTeam();
	
	List<Superhero> getSuperheroesNotTeamLeadAndNotOnTeam();
}
