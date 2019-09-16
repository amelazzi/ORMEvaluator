package DAL.MySQL;

import DAL.Common.ReactionAbstract;
import com.company.Common.Enums.ReactionType;

import java.util.Date;

public class Reaction extends ReactionAbstract {
    private int id;
    private Date reactionDate;
    private ReactionType type;
    private int userid;
    private int publicationid;

    public Reaction() {super();}

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
        return null;
    }

    @Override
    public void setType(ReactionType type) {

    }


    @Override
    public int getUserId() {
        return this.userid;
    }

    @Override
    public void setUserId(int i) {
        this.userid=i;
    }

    @Override
    public int getPublicationId() {
        return this.publicationid;
    }

    @Override
    public void setPublicationId(int i) {
        this.publicationid=i;
    }

}

