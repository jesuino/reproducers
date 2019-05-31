package reproducers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Conf {
    
    @Inject
    @ConfigProperty(name = "prop")
    String prop;
    
    public String getProp() {
        return prop;
    }

    @Override
    public String toString() {
        return "Conf [prop=" + prop + "]";
    }
    
}
