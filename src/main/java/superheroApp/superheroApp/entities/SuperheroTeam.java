package superheroApp.superheroApp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "SuperheroTeam", schema = "public")
public class SuperheroTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teamId;

	@NotNull
	private String teamName;

	@NotNull
	@Length(max = 250)
	private String headquarters;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "publicSupport_id")
	private PublicSupport publicSupport;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "teamlead_id")
	private Superhero teamLead;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "superhero_id")
	private List<Superhero> superheros;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public PublicSupport getPublicSupport() {
		return publicSupport;
	}

	public void setPublicSupport(PublicSupport publicSupport) {
		this.publicSupport = publicSupport;
	}

	public Superhero getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(Superhero teamLead) {
		teamLead.setTeamLead(true);
		this.teamLead = teamLead;
	}

	public List<Superhero> getSuperheros() {
		return superheros;
	}

	public void setSuperheros(List<Superhero> superheros) {
		for(Superhero s : superheros){
			s.setOnTeam(true);
		}
		this.superheros = superheros;
	}

}