package org.jboss.resteasy.reproducer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author wsiqueir
 *
 */
@Path("/")
public class TestResource {

	@POST
	@Consumes({ "application/xml", "application/json" })
	public void test(Test test) {
		System.out.println("test: " + test);
	}

	@POST
	public void test() {
		System.out.println("test without body");
	}

}