package superheroApp.superheroApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PublicSupport", schema = "public")
public class PublicSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String publicSupport;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublicSupport() {
		return publicSupport;
	}

	public void setPublicSupport(String publicSupport) {
		this.publicSupport = publicSupport;
	}
}
