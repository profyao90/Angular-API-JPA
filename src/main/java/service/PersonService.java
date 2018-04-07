package service;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domaine.Person;
import domaine.Residence;
import jpa.PersonDAO;
import jpa.ResidenceDAO;

@Path("/person")
public class PersonService {
	
	PersonDAO dao = new PersonDAO();
			
			@GET
			@Produces(MediaType.APPLICATION_JSON)
			public List<Person> getList() {
				return this.dao.getPersonAll();
			}
			
			@POST
			@Path("/{id}")	
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			public Person getOne(@PathParam("id") String id) {
				Long _id = Long.parseLong(id);
				return dao.getPersonBy(_id);
			}
			
			@POST
			@Path("/save")	
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
			public Response save(@QueryParam("Name") String name, @QueryParam("prenom") String prenom, @QueryParam("mail") String mail) {
				Person person = new Person();
				
				person.setName(name);
				person.setPrenom(prenom);;
				person.setMail(mail);;
				
				dao.createPerson(person);
				
				return Response.status(200).entity(person.toString()).build();
			}	

	}
