package superheroApp.superheroApp.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.PublicSupportDao;
import superheroApp.superheroApp.daos.SuperheroDao;
import superheroApp.superheroApp.entities.PublicSupport;
import superheroApp.superheroApp.entities.Superhero;
import superheroApp.superheroApp.entities.SuperheroTeam;

@Service
public class SuperheroTeamValidation {

	@Autowired
	PublicSupportDao publicSupportDao;

	@Autowired
	SuperheroDao superheroDao;

	public class SuperheroTeamException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8349927851786991593L;

		public SuperheroTeamException(String message) {
			super(message);
		}
	}

	public boolean validateSuperheroTeam(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		return validateTeamMemebers(superheroTeam) && validateTeamLeader(superheroTeam)
				&& validatePublicSupport(superheroTeam) && validateHeadquarters(superheroTeam)
				&& validateName(superheroTeam);
	}

	private boolean validateTeamMemebers(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		boolean result = true;
		try {
			List<Superhero> teamMemebers = superheroTeam.getSuperheros();
			for (Superhero s : teamMemebers) {
				String superheroName = s.getSuperheroName();
				if (superheroName.equals("")) {
					result = false;
					throw new SuperheroTeamException("Superhero name is empty");
				}
				for (Superhero b : superheroDao.getAllSuperheroes()) {
					String existingName = b.getSuperheroName();
					if (superheroName.equals(existingName)) {
						s = b;
					}
				}
			}
		} catch (NullPointerException e) {
			throw new SuperheroTeamException("Team members is null");
		}
		return result;

	}

	private boolean validateTeamLeader(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		boolean result = false;
		try {
			Superhero teamLead = superheroTeam.getTeamLead();
			List<Superhero> superheroes = superheroDao.getAllSuperheroes();
			if (teamLead.getSuperheroName().equals("")) {
				result = false;
				throw new SuperheroTeamException("Team lead superhero name is empty");
			} else {
				result = true;
			}
			String teamLeadSuperheroName = teamLead.getSuperheroName();
			for (Superhero s : superheroes) {
				String superheroName = s.getSuperheroName();
				if (superheroName.equals(teamLeadSuperheroName)) {
					superheroTeam.setTeamLead(s);
				}
			}
		} catch (NullPointerException e) {
			throw new SuperheroTeamException("Team leader is null");
		}
		return result;
	}

	private boolean validatePublicSupport(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		boolean result = false;
		try {
			String publicSupport = superheroTeam.getPublicSupport().getPublicSupport();
			List<PublicSupport> supportList = publicSupportDao.getAllPublicSupport();
			if (publicSupport.equals("")) {
				throw new SuperheroTeamException("Public support is emtpy");
			} else {
				result = true;
			}
			for (PublicSupport p : supportList) {
				if (p.getPublicSupport().equals(publicSupport)) {
					superheroTeam.setPublicSupport(p);
				}
			}
		} catch (NullPointerException e) {
			throw new SuperheroTeamException("Public support is null");
		}
		return result;

	}

	private boolean validateHeadquarters(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		boolean result = false;
		try {
			String headquarters = superheroTeam.getHeadquarters();
			if (headquarters.equals("")) {
				throw new SuperheroTeamException("Headquarter is empty");
			} else {
				result = true;
			}
		} catch (NullPointerException e) {
			throw new SuperheroTeamException("Headquarters is null");
		}
		return result;
	}

	private boolean validateName(SuperheroTeam superheroTeam) throws SuperheroTeamException {
		boolean result = false;
		try {
			String name = superheroTeam.getTeamName();
			if (name.equals("")) {
				throw new SuperheroTeamException("Name is empty");
			} else {
				result = true;
			}
		} catch (NullPointerException e) {
			throw new SuperheroTeamException("Name is null");
		}
		return result;

	}
}
