package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domaine.ElectronicDivice;
import domaine.Heater;
import domaine.Residence;

public class ElectronicDiviceDAO {
	
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	private EntityManager manager = factory.createEntityManager();

	private EntityTransaction tx = manager.getTransaction();

	public void createElectronicDivice( ElectronicDivice  electronicDivice) {
		tx.begin();
		manager.persist(electronicDivice);
		tx.commit();
	}

	public List< ElectronicDivice> getElectronicDiviceAll() {
		return manager.createQuery("Select a From  ElectronicDivice a",  ElectronicDivice.class).getResultList();
	}

	public  ElectronicDivice getElectronicDiviceBy(long id) {
		return manager.find( ElectronicDivice.class, id);
	}

	public void removeElectronicDivice(int id) {
		 ElectronicDivice ElectronicDiv = getElectronicDiviceBy(id);
		if (ElectronicDiv != null) {
			manager.remove(ElectronicDiv);
		}
	}

	public void updateElectronicDivice( ElectronicDivice  ElectronicDivice) {
		 ElectronicDivice ElectronicDiv = getElectronicDiviceBy(ElectronicDivice.getId());
		if (ElectronicDiv != null) {
			manager.merge( ElectronicDivice);
		}
	}

	public static void main(String[] args) {
		ElectronicDiviceDAO ejp = new ElectronicDiviceDAO();
		/*System.out.println(pjp.getElectronicDiviceBy(1L).getNameElectro());*/
		ResidenceDAO ResidenceDAO = new ResidenceDAO();
		Residence beaulieu = ResidenceDAO.getResidenceBy(1);
		ElectronicDivice ElectronicDivice = new ElectronicDivice("nameElectro", 10, beaulieu);
		ejp.createElectronicDivice(ElectronicDivice);
		
		
		
	}


}
