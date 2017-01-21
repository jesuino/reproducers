package org.jboss.resteasy.clientkeepalive;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.client.ClientRequest;


@Path("/")
public class SiteContentResource  {
	
	@GET
	public String getViaREST() throws Exception {
		ClientRequest clientRequest = ClientRequestFactory.getClientRequest();
		return clientRequest.get(String.class).getEntity();
	}
	
}
