package com.redhat.gss.reproducer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/serveLargeObject")
public interface ReceiveLargeObjectResource {
	
	@GET
	@Produces("application/octet-stream")
	public Response serveLargeObject(@QueryParam("filename") String filename);

}
