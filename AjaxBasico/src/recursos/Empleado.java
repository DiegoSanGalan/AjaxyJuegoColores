package recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



//import clasejava.Vehiculo;

import com.google.gson.Gson;


@Path ("/empleado") // utilizaremos ésta ruta para llamar a ésta clase.
public class Empleado {
	
	private final Logger log = LogManager.getRootLogger();

	@GET
	@Path("/info/{id}")
	//@Produces("application/json") // indica que devuelvo (Produces) un xml.
	public String buscarEmpleado(@PathParam("id") String id)
	{
		String devuelto = "";
		Gson gson = new Gson();
		devuelto = "El id buscado es: " + id;
		log.info("A recogido el id desde el JAX: " + id);
		
		System.out.println(id);
		
		return devuelto;
	}
	
	
	 
	 @POST
		@Consumes(MediaType.APPLICATION_JSON)  // espera un json. Consumes
		public Response creaVehiculo(String p) { // y se mete en el String p
	 
		 	Gson gson = new Gson();
		 	//Vehiculo vehiculo = gson.fromJson(p, Vehiculo.class);
		 	
		 	//System.out.println("El vehiculo introducido es: " + vehiculo.toString());
		 
		    System.out.println(p.toString());
	        
			//String result = "Ha ido bien, chaval ;)" + vehiculo.toString();
		    String result = "Ha ido bien, chaval ;)";
			return Response.status(201).entity(result).build();
	 
		}

	 @DELETE
	 @Consumes (MediaType.APPLICATION_JSON)
	 @Path("/info/{marca}") //team es un parametro que le paso y se pone entre {}
	 public Response borrarVehiculo (@PathParam("marca") String v)
	 {
		 Gson gson = new Gson();
		 //Vehiculo vehiculo = new Vehiculo ("5161", "Seat");
		 
		 
		 String result = "Se ha borrado el vehiculo" + v.toString();
		 return Response.status(200).entity(result).build();
	 }
	
	
	
	
}
