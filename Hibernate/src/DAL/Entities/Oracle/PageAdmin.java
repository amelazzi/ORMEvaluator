package DAL.Entities.Oracle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("10")
public class PageAdmin extends User {
    public PageAdmin(){super();}
}
