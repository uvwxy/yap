package yanp.api.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("v1")
public class PollerService {

	@GET
	@Path("/startPoller")
	public String startPoller(@QueryParam(value = "ip") String ip) {
		String ret = "Started for: " + ip;

		System.out.println(ret);

		return ret;
	}
}
