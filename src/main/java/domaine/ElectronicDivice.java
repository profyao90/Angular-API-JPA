package domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDivice {
	@Id
	@GeneratedValue
	private long id;
	private String nameElectro;
	private int avgConsommation;

	@ManyToOne
	private Residence residence;

	public ElectronicDivice() {

	}


	public ElectronicDivice(String nameElectro, int avgConsommation, Residence residence) {
		super();
		this.nameElectro = nameElectro;
		this.avgConsommation = avgConsommation;
		this.residence = residence;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameElectro() {
		return nameElectro;
	}

	public void setNameElectro(String nameElectro) {
		this.nameElectro = nameElectro;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public int getAvgConsommation() {
		return avgConsommation;
	}

	public void setAvgConomation(int avgConsommation) {
		this.avgConsommation = avgConsommation;
	}

}
