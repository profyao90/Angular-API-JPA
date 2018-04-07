package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import domaine.ElectronicDivice;
import domaine.Person;
import domaine.Residence;

public class JpaTest {

	private Collection<Residence> residence = new ArrayList<Residence>();
	//private Collection <ElectronicDivice> elect = new  ArrayList<ElectronicDivice>();
	
	private EntityManager manager;
	public JpaTest(EntityManager manager2) {
		this.manager = manager2;	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		JpaTest jpa = new JpaTest(manager);
		jpa.createPersonne();
		
		jpa.listPerson();
		try {
			
			
/*Person p = new Person();
			p.setName("martin");
			manager.persist(p);*/
	
			
			
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";
		
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin"); 
//		List<Person> res = q.getResultList();
		
//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();
		
	}
	private void createPersonne() {
		int idPerson = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
		if (idPerson == 2) {
			//Collection <ElectronicDivice> elect = new  ArrayList<ElectronicDivice>();
			ElectronicDivice elect = new ElectronicDivice();
		manager.persist(elect);
		//personne.setId(0);
		//Person personne = new Person(0, "Yao", "Amine", "Bah@gmail.com", residence, elect);
		Person personne = new Person();
		personne.setName("Amadou");
		personne.setPrenom("Bah");
		personne.setMail("Bah.gmail");
		personne.setResidences(residence);
		manager.persist(personne);
		
		}
		
		
	}
	
	private void createElectronic() {
		int idPerson = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
		if (idPerson == 2) {
			//Collection <ElectronicDivice> elect = new  ArrayList<ElectronicDivice>();
			ElectronicDivice elect = new ElectronicDivice();
		manager.persist(elect);
		//personne.setId(0);
		//Person personne = new Person(0, "Yao", "Amine", "Bah@gmail.com", residence, elect);
		Person personne = new Person();
		personne.setName("Amadou");
		personne.setPrenom("Bah");
		personne.setMail("Bah.gmail");
		personne.setResidences(residence);
		manager.persist(personne);
		
		}
		
		
	}
	private void listPerson() {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of person:" + resultList.size());
		for (Person next : resultList) {
			System.out.println("next person: " + next);
		}
	}

	


	

}
