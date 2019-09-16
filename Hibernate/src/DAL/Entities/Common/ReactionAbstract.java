package DAL.Entities.Common;


import com.company.Common.Enums.ReactionType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class ReactionAbstract {
    @Id
    @GeneratedValue
    private int id;

    public  ReactionAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract Date getReactionDate();

    public abstract void setReactionDate(Date reactionDate);

    public abstract ReactionType getType();

    public abstract void setType(ReactionType type);

    public abstract UserAbstract getUserAbstract();

    public abstract void setUserAbstract(UserAbstract userAbstract);

    public abstract PublicationAbstract getPublications();

    public abstract void setPublications(PublicationAbstract publicationAbstracts);

}
