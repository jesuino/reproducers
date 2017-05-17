package reproducer;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlElement(required = true, name = "name-jaxb")
    protected String name;
    
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
