package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("test")
public class ReadPropsResource {

    @ConfigProperty(name="reproducer.number")
    int intProp;
    
    @ConfigProperty(name="reproducer.text")
    String strProp;
    
    @GET
    public String get() {
        return "str prop " + strProp + " | intProp " + intProp; 
    }
    
}
