package DAL.Entities.PostgreSQL;

import DAL.Entities.Common.PublicationAbstract;
import DAL.Entities.Common.WallAbstract;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedNativeQuery(
        name = "InsertWall",
        query = "CALL insertWall(:id, :description, :wallType)"
)


@Entity
@Table(name = "WALL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="wallType",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Wall extends WallAbstract {
    @Id
    @GeneratedValue()
    private int id;
    private String description;

    @OneToMany(mappedBy = "wall")
    private List<Publication> publications = new ArrayList<Publication>(0);

    public Wall(){super();}

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public List<PublicationAbstract> getPublications() {
        List<PublicationAbstract>publicationAbstracts = new ArrayList<PublicationAbstract>(0);
        for (Publication publication: this.publications){
            publicationAbstracts.add(publication);
        }
        return publicationAbstracts;
    }

    @Override
    public void setPublications() {
        for (PublicationAbstract publicationAbstract: publications){
            this.publications.add((Publication) publicationAbstract);
        }
    }


}
