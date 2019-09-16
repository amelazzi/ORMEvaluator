package DAL.Entities.Common;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class WallAbstract {
    @Id
    @GeneratedValue
    private int id;

    public WallAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract List<PublicationAbstract> getPublications();

    public abstract void setPublications();
}
