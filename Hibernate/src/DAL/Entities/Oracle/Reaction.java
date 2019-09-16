package DAL.Entities.Oracle;
import DAL.Entities.PostgreSQL.PostgreSQLEnumType;
import com.company.Common.Enums.ReactionType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;


@TypeDef(
        name = "reactionType_enum",
        typeClass = PostgreSQLEnumType.class
)


@Entity
@Table(name = "reaction")
public class Reaction{
    @Id
    @GeneratedValue
    private int id;
    private Date reactionDate;

    //@Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "type", table = "reaction")
    //@Type( type = "reactionType_enum" )
    private ReactionType reactionType;

    @ManyToOne
    @JoinColumn(name = "publicationid")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Reaction(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReactionDate() {
        return reactionDate;
    }

    public void setReactionDate(Date reactionDate) {
        this.reactionDate = reactionDate;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

