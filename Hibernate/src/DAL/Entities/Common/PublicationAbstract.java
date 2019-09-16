package DAL.Entities.Common;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class PublicationAbstract {
    @Id
    @GeneratedValue
    private int id;

    public PublicationAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getExtension();

    public abstract void setExtension(String extension);


    public abstract Date getDate();

    public abstract void setDate(Date date);

    public abstract UserAbstract getUser();

    public abstract void setUser(UserAbstract user);

    public abstract WallAbstract getWall();

    public abstract void setWall(WallAbstract wall);

    public abstract List<ReactionAbstract> getReactions();

    public abstract void setReactions(List<ReactionAbstract> reactions);


}
