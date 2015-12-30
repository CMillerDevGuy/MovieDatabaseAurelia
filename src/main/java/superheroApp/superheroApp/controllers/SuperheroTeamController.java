package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import superheroApp.superheroApp.entities.SuperheroTeam;
import superheroApp.superheroApp.services.SuperheroTeamService;
import superheroApp.superheroApp.validation.SuperheroTeamValidation.SuperheroTeamException;

@RestController
public class SuperheroTeamController {
	@Autowired
	SuperheroTeamService superheroTeamService;

	@RequestMapping(value = "/superheroTeam", method = RequestMethod.GET)
	public List<SuperheroTeam> getAllSuperheroes() {
		return superheroTeamService.getAllSuperheroTeams();
	}

	@RequestMapping(value = "/superheroTeam/{teamId}", method = RequestMethod.GET)
	public SuperheroTeam getTeamById(@PathVariable Integer teamId) {
		return superheroTeamService.getTeamById(teamId);
	}

	@RequestMapping(value = "/superheroTeam", method = RequestMethod.POST)
	public void addNewSuperheroTeam(@RequestBody SuperheroTeam superheroTeam) throws Exception {
		try {
			superheroTeamService.addNewSuperheroTeam(superheroTeam);
		} catch (SuperheroTeamException e) {
			throw new Exception(e.getMessage());
		}
	}

	@RequestMapping(value = "/superheroTeam", method = RequestMethod.PUT)
	public void updateSuperheroTeam(@RequestBody SuperheroTeam superheroTeam) throws SuperheroTeamException {
		superheroTeamService.updateSuperheroTeam(superheroTeam);
	}

	@RequestMapping(value = "/superheroTeam/{teamId}", method = RequestMethod.DELETE)
	public void deleteSuperheroTeam(@PathVariable Integer teamId) {
		superheroTeamService.deleteSuperheroTeam(teamId);
	}
}
