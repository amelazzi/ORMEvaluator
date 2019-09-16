package DAL.Entities.PostgreSQL;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "post")
@PrimaryKeyJoinColumn(name = "publicationid", referencedColumnName = "id")
public class Post extends Publication {
    public Post(){super();}
}
