package domaine;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String prenom;
	private String mail;

	@OneToMany(mappedBy = "personne", cascade = CascadeType.PERSIST)
	private Collection<Residence> residences;

	public Person() {

	}

	public Person( String name, String prenom, String mail) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.mail = mail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Collection<Residence> getResidences() {
		return residences;
	}

	public void setResidences(Collection<Residence> residences) {
		this.residences = residences;
	}

}
