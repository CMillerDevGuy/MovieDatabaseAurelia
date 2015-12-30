package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.SuperheroDao;
import superheroApp.superheroApp.daos.SuperheroTeamDao;
import superheroApp.superheroApp.entities.Superhero;
import superheroApp.superheroApp.entities.SuperheroTeam;
import superheroApp.superheroApp.services.SuperheroTeamService;
import superheroApp.superheroApp.validation.SuperheroTeamValidation;
import superheroApp.superheroApp.validation.SuperheroTeamValidation.SuperheroTeamException;

@Service
public class SuperheroTeamServiceImpl implements SuperheroTeamService {
	@Autowired
	SuperheroTeamDao superheroTeamDao;

	@Autowired
	SuperheroTeamValidation superheroTeamValidation;
	
	@Autowired
	SuperheroDao superheroDao;

	public SuperheroTeam getTeamById(Integer teamId) {
		return superheroTeamDao.getTeamById(teamId);
	}

	public List<SuperheroTeam> getAllSuperheroTeams() {
		return superheroTeamDao.getAllSuperherTeams();
	}

	public void addNewSuperheroTeam(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		if (superheroTeamValidation.validateSuperheroTeam(superheroTeam)) {
			for(Superhero s : superheroTeam.getSuperheros()){
				s.setOnTeam(true);
				superheroDao.updateSuperhero(s);
			}
			Superhero teamLead = superheroTeam.getTeamLead();
			teamLead.setOnTeam(true);
			teamLead.setTeamLead(true);
			superheroDao.updateSuperhero(teamLead);
			superheroTeamDao.addNewSuperheroTeam(superheroTeam);
		}
	}

	public void updateSuperheroTeam(SuperheroTeam superheroTeam) {
		superheroTeamDao.updateSuperheroTeam(superheroTeam);
	}

	public void deleteSuperheroTeam(Integer teamId) {
		superheroTeamDao.deleteSuperheroTeam(teamId);
	}

}