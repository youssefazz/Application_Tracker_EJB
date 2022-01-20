package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import dao.ISmartPhoneLocal;
import entity.SmartPhone;

@Stateless
@Path("/")
public class SmartPhoneRest {
	
	@EJB
	private ISmartPhoneLocal service;
	
	@GET
	@Path("/phones/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SmartPhone getSmartPhone(@PathParam(value = "id") Long id) {
		return service.findById(id);
	}
	
	@GET
	@Path("/phones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SmartPhone>getAllPhones(){
		return service.findAll();
	}
	
	@POST
	@Path("/phones")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void createSmartPhone(SmartPhone sp) {
		service.create(sp);
	}
	
	@DELETE
	@Path("/phones/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSmatPhoneById(@PathParam(value = "id") Long id) {
		service.deleteById(id);
	}
	
	
}
