
package reproducers;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;

public class Startup {
    
    @Inject
    Conf conf;
    
    @Inject
    @ConfigProperty(name = "prop")
    String prop;
    
    public void start(@Observes StartupEvent ev) {
        System.out.println("CONF IS " + conf);
        System.out.println("PROP IS " + conf.prop);
        System.out.println("PROP GETTER IS " + conf.getProp());
        System.out.println("INJECTED PROP IS " + prop);
    } 

}