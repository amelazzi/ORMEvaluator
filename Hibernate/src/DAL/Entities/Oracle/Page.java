package DAL.Entities.Oracle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Page extends Wall {
    public Page(){super();}
}
