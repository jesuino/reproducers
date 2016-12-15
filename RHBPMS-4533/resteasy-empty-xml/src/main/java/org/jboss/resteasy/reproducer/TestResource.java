package org.jboss.resteasy.reproducer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;


/**
 * @author wsiqueir
 *
 */
@Path("/")
public class TestResource {

	@POST
	public void test(Test test) {
		System.out.println("test: " + test);
	}
	
	
	/**
	 * adding this is not working as well
	 */
	@POST
	public void test() {
		System.out.println("test without body");
	}
	
}