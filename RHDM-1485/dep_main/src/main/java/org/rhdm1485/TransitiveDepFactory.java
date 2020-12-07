package org.rhdm1485;
import org.rhdm1485.TransitiveDepCl;

public class TransitiveDepFactory {

	public static TransitiveDepCl produce(String name) {
		return new TransitiveDepCl(name);
	}
} 
