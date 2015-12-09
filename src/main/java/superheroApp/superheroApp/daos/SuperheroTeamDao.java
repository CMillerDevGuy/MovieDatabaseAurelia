package superheroApp.superheroApp.daos;

import java.util.List;

import superheroApp.superheroApp.entities.SuperheroTeam;


public interface SuperheroTeamDao {

	List<SuperheroTeam> getAllSuperherTeams();

	void addNewSuperheroTeam(SuperheroTeam superheroTeam);

	void updateSuperheroTeam(SuperheroTeam superheroTeam);

	void deleteSuperheroTeam(SuperheroTeam superheroTeam);

}
