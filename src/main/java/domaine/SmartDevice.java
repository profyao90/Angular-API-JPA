package domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import domaine.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SmartDevice {
	long id;
	
	Residence maison;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Residence getMaison() {
		return maison;
	}

	public void setMaison(Residence maison) {
		this.maison = maison;
	}

	@Override
	public String toString() {
		return "SmartDevice [id=" + id + ", maison=" + maison + "]";
	}
	
}
