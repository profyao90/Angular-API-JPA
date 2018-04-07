package fr.istic.sir.rest;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domaine.*;
import jpa.*;

@Path("/API")
public class SampleWebService {
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String bienvenu() {
		return "Bienvenu sur notre API voici les routes possibles : \n personnes \n maisons ";
	}

	@GET
	@Path("/personnes")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Person> getPersonnes() {

		Collection<Person> result = manager.createQuery("Select p from Personne p", Person.class).getResultList();

		return result;
	}

	@GET
	@Path("/personnes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonne(@PathParam("id") int id) {

		Person result = manager.createQuery("Select p from Personne p where p.id = :id", Person.class)
				.setParameter("id", id).getResultList().get(0);

		return result;
	}

	@GET
	@Path("/maisons")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Residence> getMaison() {

		Collection<Residence> result = manager.createQuery("Select m from Maison m", Residence.class).getResultList();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();

		return result;
	}

	@POST
	@Path("/personnes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(@QueryParam("prenom") String prenom, @QueryParam("name") String name,
			@QueryParam("mail") String mail) {
		Person p = new Person();
		p.setName(name);
		p.setPrenom(prenom);
		p.setMail(mail);

		tx.begin();
		manager.persist(p);
		tx.commit();

		String result = "Nom: " + name + "\n Prenom : " + prenom + "\n Mail : " + mail;
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/maisons")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMaison(@QueryParam("tailleR") int tailleR, 
			@QueryParam("nbpiece") int nbPieces, @QueryParam("idProp") long idP) {
		Residence maison = new Residence();
		maison.setId(idP);
		maison.setNombredepieces(nbPieces);
		maison.setTailleResidence(tailleR);

		/**Person residenceName = manager.createQuery("Select p from Person p where p.id = :id", Person.class)
				.setParameter("id", idP).getResultList().get(0);

		maison.setNameResidence(residenceName);*/

		tx.begin();
		manager.persist(maison);
		tx.commit();

		String result =  " Nombre de piece : " + nbPieces + "; Home taille : " +tailleR + "; Home ID : " + idP;;
		return Response.status(200).entity(result).build();
	}
}
