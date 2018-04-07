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

import domaine.Residence;
import jpa.ResidenceDAO;


@Path("/residence")
public class ResidenceService {
	
	ResidenceDAO dao = new ResidenceDAO();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Residence> getList() {
			return dao.getResidenceAll();
		}
		
		@POST
		@Path("/{id}")	
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Residence getOne(@PathParam("id") String id) {
			Long _id = Long.parseLong(id);
			return dao.getResidenceBy(_id);
		}
		
		@POST
		@Path("/save")	
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response save(@QueryParam("nameResidence") String nom, @QueryParam("nombredepieces") String nbrePiece, @QueryParam("tailleResidence") String taille) {
			Residence residence = new Residence();
			
			residence.setNameResidence(nom);
			residence.setNombredepieces(5);;
			residence.setTailleResidence(10);;
			
			dao.createResidence(residence);
			
			return Response.status(200).entity(residence.toString()).build();
		}	

}
