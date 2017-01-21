package org.jboss.resteasy.clientkeepalive;

import org.jboss.resteasy.client.ClientRequest;

public class ClientRequestFactory {
	
	public static ClientRequest getClientRequest() {
		String url = "http://stackoverflow.com/";
		ClientRequest request = new ClientRequest(url);
		request.getHeaders().add("Transfer-Encoding", "gzip");
		request.getHeaders().add("Content-Encoding", "gzip");
		return request;
	}


}
