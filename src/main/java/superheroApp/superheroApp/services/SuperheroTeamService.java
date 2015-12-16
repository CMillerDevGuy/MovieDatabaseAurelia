package superheroApp.superheroApp.services;

import java.util.List;

import superheroApp.superheroApp.entities.SuperheroTeam;
import superheroApp.superheroApp.validation.SuperheroTeamValidation.SuperheroTeamException;

public interface SuperheroTeamService {

	List<SuperheroTeam> getAllSuperheroTeams();

	void addNewSuperheroTeam(SuperheroTeam superheroTeam) throws SuperheroTeamException;

	void updateSuperheroTeam(SuperheroTeam superheroTeam);

	void deleteSuperheroTeam(SuperheroTeam superheroTeam);

	SuperheroTeam getTeamById(Integer teamId);

}
