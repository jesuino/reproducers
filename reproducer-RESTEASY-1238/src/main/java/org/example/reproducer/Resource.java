package org.example.reproducer;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("write-resp")
public class Resource {

	@DefaultValue("10000")
	@QueryParam("v")
	int v;

	@GET
	public String sleep() throws InterruptedException {
		String m = "";
		int i = 0;
		System.out.println("response will be created");
		while (i < 10000) {
			m += System.currentTimeMillis();
			i++;
		}
		System.out.println("writing string of size " + m.length() + " to the response");
		return m;
	}

}
