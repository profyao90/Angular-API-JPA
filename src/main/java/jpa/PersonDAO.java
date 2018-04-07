package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domaine.Person;

public class PersonDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

	private EntityManager manager = factory.createEntityManager();

	private EntityTransaction tx = manager.getTransaction();

	public void createPerson(Person person) {
		tx.begin();
		manager.persist(person);
		tx.commit();
	}

	public List<Person> getPersonAll() {
		return manager.createQuery("Select a From Person a", Person.class).getResultList();
	}

	public Person getPersonBy(long id) {
		return manager.find(Person.class, id);
	}

	public void removeProfessor(int id) {
		Person pers = getPersonBy(id);
		if (pers != null) {
			manager.remove(pers);
		}
	}

	public void updatePerson(Person person) {
		Person pers = getPersonBy(person.getId());
		if (pers != null) {
			manager.merge(person);
		}
	}

	public static void main(String[] args) {
		PersonDAO pjp = new PersonDAO();
		System.out.println(pjp.getPersonBy(1L).getPrenom());
	}

}
