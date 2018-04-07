package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domaine.Heater;
import domaine.Person;
import domaine.Residence;

public class HeaterDAO {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	private EntityManager manager = factory.createEntityManager();

	private EntityTransaction tx = manager.getTransaction();

	public void createHeater(Heater Heater) {
		tx.begin();
		manager.persist(Heater);
		tx.commit();
	}

	public List<Heater> getHeaterAll() {
		return manager.createQuery("Select a From Heater a", Heater.class).getResultList();
	}

	public Heater getHeaterBy(long id) {
		return manager.find(Heater.class, id);
	}

	public void removeHeater(int id) {
		Heater heat = getHeaterBy(id);
		if (heat != null) {
			manager.remove(heat);
		}
	}

	public void updateHeater(Heater Heater) {
		Heater heat = getHeaterBy(Heater.getId());
		if (heat != null) {
			manager.merge(Heater);
		}
	}

	public static void main(String[] args) {
		HeaterDAO hjp = new HeaterDAO();
		/*System.out.println(hjp.getHeaterBy(1L).getNameHeater());*/
		ResidenceDAO ResidenceDAO = new ResidenceDAO();
		Residence beaulieu = ResidenceDAO.getResidenceBy(1L);
		Heater Heater = new Heater("nameHeater",100, beaulieu);
		hjp.createHeater(Heater);
	}


}
