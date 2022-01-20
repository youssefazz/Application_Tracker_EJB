package ws;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
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
@WebService
public class PositionSOAP {
	
	@EJB
	private IPositionLocal service;
	

	public Position getPositions(@PathParam(value = "id") Long id) {
		return service.findById(id);
	}
	
	
	@WebMethod
	public List<Position>getAllPositions(){
		return service.findAll();
	}
	

	public List<Position>getAllPositionsDate(@FormParam(value="date1") Date d1,@FormParam(value="date2") Date d2){
		return service.getPositionBetweenDate(d1, d2);
	}
	
	@WebMethod
	public void createPosition(Position p) {
		service.create(p);
	}
	
	@DELETE
	@Path("/p/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePositionById(@PathParam(value = "id") Long id) {
		service.deleteById(id);
	}
	
}
