package DAL.Entities.MySQL;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Page extends Wall {

}
