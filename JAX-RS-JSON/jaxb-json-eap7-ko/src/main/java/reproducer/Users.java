package reproducer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsersType", propOrder = {
    "users"
})
@XmlRootElement(name = "Users")
public class Users implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "users")
    protected List<User> users;

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<User>();
        }
        return this.users;
    }

}
