package org.jboss.resteasy.reproducer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/")
public class TestResource {

	@POST
	public void test(Test test) {
		System.out.println("test: " + test);
	}
	
}