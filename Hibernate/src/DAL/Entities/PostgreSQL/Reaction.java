package DAL.Entities.PostgreSQL;

import DAL.Entities.Common.PublicationAbstract;
import DAL.Entities.Common.ReactionAbstract;
import DAL.Entities.Common.UserAbstract;
import com.company.Common.Enums.ReactionType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;


@TypeDef(
        name = "reactionType_enum",
        typeClass = PostgreSQLEnumType.class
)


@Entity
@Table(name = "reaction")
public class Reaction extends ReactionAbstract {
    @Id
    @GeneratedValue
    private int id;
    private Date reactionDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "type", table = "reaction")
    @Type( type = "reactionType_enum" )
    private ReactionType type;

    @ManyToOne
    @JoinColumn(name = "publicationid")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Reaction(){super();}

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public Date getReactionDate() {
        return this.reactionDate;
    }

    @Override
    public void setReactionDate(Date reactionDate) {
        this.reactionDate=reactionDate;
    }

    @Override
    public ReactionType getType() {
        return this.type;
    }

    @Override
    public void setType(ReactionType type) {
        this.type=type;
    }

    @Override
    public UserAbstract getUserAbstract() {
        return this.user;
    }

    @Override
    public void setUserAbstract(UserAbstract userAbstract) {
        this.user = (User) userAbstract;
    }

    @Override
    public PublicationAbstract getPublications() {
        return this.publication;
    }

    @Override
    public void setPublications(PublicationAbstract publicationAbstracts) {
        this.publication = (Publication) publicationAbstracts;
    }


}

