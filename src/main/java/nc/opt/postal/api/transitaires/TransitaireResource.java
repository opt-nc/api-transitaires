package nc.opt.postal.api.transitaires;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/transitaires")
public class TransitaireResource {

    @Inject
    Jsonb jsonb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Transitare[] list() {
      return jsonb.fromJson(getClass().getResourceAsStream("/data.json"), Transitare[].class);
    }
}
