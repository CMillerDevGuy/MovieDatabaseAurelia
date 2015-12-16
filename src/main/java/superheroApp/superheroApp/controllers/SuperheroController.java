package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import superheroApp.superheroApp.entities.Superhero;
import superheroApp.superheroApp.services.SuperheroService;
import superheroApp.superheroApp.validation.SuperheroValidation.SuperheroException;

@RestController
public class SuperheroController {
	@Autowired
	SuperheroService superheroService;

	@RequestMapping(value = "/superhero", method = RequestMethod.GET)
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
	}

	@RequestMapping(value = "/superhero/{id}", method = RequestMethod.GET)
	public Superhero getSuperheroById(@PathVariable Integer id) {
		return superheroService.getSuperheroById(id);
	}

	@RequestMapping(value = "/superhero", method = RequestMethod.POST)
	public void addNewSuperhero(@RequestBody Superhero superhero) throws Exception {
		try {
			superheroService.addNewSuperhero(superhero);
		} catch (SuperheroException e) {
			throw new Exception(e.getMessage());
		}
	}

}
