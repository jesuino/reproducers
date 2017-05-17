package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
public class Hello {
	
	@GET
	@Path("str")
	public Object hello() {
		System.out.println("now saying hello returning str");
		return "Hello";
	}
	
	@GET
	@Path("obj")
	public Object helloObj() {
		System.out.println("now saying hello returning an obj");
		return new Object();
	}

}
