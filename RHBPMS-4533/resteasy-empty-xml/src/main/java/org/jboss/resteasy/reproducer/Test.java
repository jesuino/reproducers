package org.jboss.resteasy.reproducer;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Test {
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	
	
}
