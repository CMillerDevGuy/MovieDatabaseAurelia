package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.SuperheroDao;
import superheroApp.superheroApp.entities.Superhero;
import superheroApp.superheroApp.services.SuperheroService;
import superheroApp.superheroApp.validation.SuperheroValidation;
import superheroApp.superheroApp.validation.SuperheroValidation.SuperheroException;

@Service
public class SuperheroServiceImpl implements SuperheroService {
	@Autowired
	SuperheroDao superheroDao;
	@Autowired
	SuperheroValidation superheroValidation;

	public List<Superhero> getAllSuperheroes() {
		return superheroDao.getAllSuperheroes();
	}

	public Superhero getSuperheroById(Integer id) {
		return superheroDao.getSuperheroById(id);
	}

	public void addNewSuperhero(Superhero superhero) throws SuperheroException {
		if (superheroValidation.validateSuperhero(superhero)) {
			superheroDao.addNewSuperhero(superhero);
		}
	}

	public List<Superhero> getSuperheroesNotOnTeam() {
		return superheroDao.getSuperheroesNotOnTeam();
	}

	public List<Superhero> getSuperheroesNotTeamLeadAndNotOnTeam() {
		return superheroDao.getSuperheroesNotTeamLeadAndNotOnTeam();
	}
}
