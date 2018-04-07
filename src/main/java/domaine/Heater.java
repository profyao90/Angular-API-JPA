package domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater {
	@Id
	@GeneratedValue
	private long Id;
	private String nameHeater;
	private int temperature;
	public int getTemperature() {
		return temperature;
	}

	

	@ManyToOne
	private Residence residence;

	public Heater() {

	}

	public Heater(String nameHeater, int temperature, Residence residence) {
		super();
		this.nameHeater = nameHeater;
		this.temperature = temperature;
		this.residence = residence;
	}

	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int gettemperature() {
		return temperature;
	}

	public void setTaille(int temperature) {
		this.temperature = temperature;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNameHeater() {
		return nameHeater;
	}

	public void setNameHeater(String nameHeater) {
		this.nameHeater = nameHeater;
	}

}
