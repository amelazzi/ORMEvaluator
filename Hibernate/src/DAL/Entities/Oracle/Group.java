package DAL.Entities.Oracle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Group extends Wall {
    public Group(){super();}
}
