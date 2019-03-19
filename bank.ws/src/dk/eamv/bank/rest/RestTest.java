package dk.eamv.bank.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resttest")
public class RestTest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("number")
	public int number() {
		return (int)Math.random()*2;
	}
}
