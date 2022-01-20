package webservice;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.IPositionLocal;
import entity.Position;

@Stateless
@Path("/")
public class PositionRest {
	
	@EJB
	private IPositionLocal service;
	
	@GET
	@Path("/positions/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Position getPositions(@PathParam(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GET
	@Path("/positions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Position>getAllPositions(){
		return service.findAll();
	}
	
	@POST
	@Path("/positions/date")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Position>getAllPositionsDate(@FormParam(value="date1") Date d1,@FormParam(value="date2") Date d2){
		return service.getPositionBetweenDate(d1, d2);
	}
	
	@POST
	@Path("/positions")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void createPosition(Position p) {
		service.create(p);
	}
	
	@DELETE
	@Path("/positions/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePositionById(@PathParam(value = "id") Long id) {
		service.deleteById(id);
	}
	
}
