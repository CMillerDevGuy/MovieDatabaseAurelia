package superheroApp.superheroApp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Powers", schema = "public")
public class Power {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "powerName", unique = true)
	private String powerName;

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "powerType_Id")
	private PowerType powerType;

	@NotNull
	private String powerDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public PowerType getPowerType() {
		return powerType;
	}

	public void setPowerType(PowerType powerType) {
		this.powerType = powerType;
	}

	public String getPowerDescription() {
		return powerDescription;
	}

	public void setPowerDescription(String powerDescription) {
		this.powerDescription = powerDescription;
	}

}