package DAL.Entities.Oracle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "InsertWall",
        query = "CALL insertWall(:description, :wallType)"
)

@Entity
@Table(name = "WALL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="wallType",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Wall {
    @Id
    @GeneratedValue
    private int id;
    private String description;

    @OneToMany(mappedBy = "wall")
    private List<Publication> publications = new ArrayList<Publication>(0);

    public Wall(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }
}
