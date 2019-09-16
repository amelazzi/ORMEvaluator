package DAL.Entities.Oracle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User {
    public Admin(){super();}
}
