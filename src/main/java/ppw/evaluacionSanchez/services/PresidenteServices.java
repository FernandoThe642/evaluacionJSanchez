package ppw.evaluacionSanchez.services;


import java.util.List;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ppw.evaluacionSanchez.model.Presidente;

import ppw.evaluacionSanchez.business.GestionPresidentes;

@Path("/Presidentes")
public class PresidenteServices {
	
	@Inject
	private GestionPresidentes gPresidentes;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Presidente> list(){
		return gPresidentes.getAll();
	}
	
	
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response create(Presidente presidente) {
        try {
            gPresidentes.agregarPresidente(presidente);
			return Response.ok(presidente).build();
        } catch (Exception e) {

			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Eror en BD")).build();
        }
        
	
    }
	


	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/{id}")
    public Response read(@PathParam("id") String id) {
        if (id == null || !id.matches("\\d{10}")) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity(new Respuesta(Respuesta.ERROR, "Cédula incorrecta"))
                           .build();
        }
        try {
            Presidente presidente = gPresidentes.getPresidente(id);
            return Response.ok(presidente).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Presidente no encontrado")).build();
        }
    }

}
