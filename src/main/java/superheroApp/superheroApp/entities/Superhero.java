package superheroApp.superheroApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Superheroes", schema = "public")
public class Superhero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superheroId;

	@Length(max = 250)
	@Column(name = "superheroName", unique = true)
	private String superheroName;

	@Length(max = 250)
	private String realName;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "origin_id")
	private Origin origin;

	private String costumeImage;

	private String height;

	private int weight;

	@ManyToMany//(cascade = CascadeType.MERGE)
	@JoinTable(name = "public.superhero_powers", joinColumns = {
			@JoinColumn(name = "superhero_id") }, inverseJoinColumns = { @JoinColumn(name = "power_id") })
	private Set<Power> powers = new HashSet<Power>();

	private boolean teamLead = false;
	
	private boolean onTeam = false;

	public boolean isOnTeam() {
		return onTeam;
	}

	public void setOnTeam(boolean onTeam) {
		this.onTeam = onTeam;
	}

	public boolean isTeamLead() {
		return teamLead;
	}

	public void setTeamLead(boolean teamLead) {
		this.teamLead = teamLead;
	}

	public Integer getSuperheroId() {
		return superheroId;
	}

	public Set<Power> getPowers() {
		return powers;
	}

	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}

	public void setSuperheroId(Integer superheroId) {
		this.superheroId = superheroId;
	}

	public String getSuperheroName() {
		return superheroName;
	}

	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public String getCostumeImage() {
		return costumeImage;
	}

	public void setCostumeImage(String costumeImage) {
		this.costumeImage = costumeImage;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	/*
	 * public String getWeight() { return weight; }
	 * 
	 * public void setWeight(String weight) { this.weight = weight; }
	 */

}
