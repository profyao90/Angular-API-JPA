package domaine;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Residence {

	@Id
	@GeneratedValue
	private long Id;
	private String nameResidence;
	private double tailleResidence;
	private int nombredepieces;

	@ManyToOne
	private Person personne;

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	private Collection<ElectronicDivice> electronicdevices;

	public Residence(String nameResidence, double tailleResidence, int nombredepieces, Person personne,
			Collection<ElectronicDivice> electronicdevices, Collection<Heater> heaters) {
		super();
		this.nameResidence = nameResidence;
		this.tailleResidence = tailleResidence;
		this.nombredepieces = nombredepieces;
		this.personne = personne;
		this.electronicdevices = electronicdevices;
		this.heaters = heaters;
	}

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	private Collection<Heater> heaters;

	public Residence() {
		// TODO Auto-generated constructor stub
	}

	public Residence(String nameResidence, Person personne, Collection<Heater> heaters) {
		super();
		this.nameResidence = nameResidence;
		this.personne = personne;
		this.heaters = heaters;
	}

	public Person getPersonne() {
		return personne;
	}

	public void setPersonne(Person personne) {
		this.personne = personne;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNameResidence() {
		return nameResidence;
	}

	public void setNameResidence(String nameResidence) {
		this.nameResidence = nameResidence;
	}

	public Collection<ElectronicDivice> getElectronicdevices() {
		return electronicdevices;
	}

	public void setElectronicdevices(Collection<ElectronicDivice> electronicdevices) {
		this.electronicdevices = electronicdevices;
	}

	public double getTailleResidence() {
		return tailleResidence;
	}

	public void setTailleResidence(double tailleResidence) {
		this.tailleResidence = tailleResidence;
	}

	public int getNombredepieces() {
		return nombredepieces;
	}

	public void setNombredepieces(int nombredepieces) {
		this.nombredepieces = nombredepieces;
	}

	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}

	public Collection<Heater> getHeaters() {
		return heaters;
	}

}
