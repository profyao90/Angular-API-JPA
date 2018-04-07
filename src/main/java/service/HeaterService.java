package service;

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

import domaine.Heater;
import jpa.HeaterDAO;

public class HeaterService {

	HeaterDAO dao = new HeaterDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Heater> getList() {
		return dao.getHeaterAll();
	}

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Heater getOne(@PathParam("id") String id) {
		Long _id = Long.parseLong(id);
		return dao.getHeaterBy(_id);
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@QueryParam("nameHeater") String nameHeater, @QueryParam("temperature") int temperature) {
		Heater heater = new Heater();

		heater.setNameHeater(nameHeater);
		heater.setTemperature(10);

		this.dao.createHeater(heater);

		return Response.status(200).entity(heater.toString()).build();
	}

}
