package DAL.PostgreSQL;

import DAL.Common.PublicationAbstract;
import DAL.Common.ReactionAbstract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Publication extends PublicationAbstract {
    private int id;
    private String description;
    private Date date;
    private int userid;
    private int wallid;
    private List<Reaction> reactions = new ArrayList<Reaction>(0);

    public Publication() {super();}

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
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getExtension() {
        return null;
    }

    @Override
    public void setExtension(String extension) {

    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public void setDate(Date date) {
        this.date=date;
    }

    @Override
    public int getUserId() {
        return this.userid;
    }

    @Override
    public void setUserId(int userId) {
        this.userid=userId;
    }

    @Override
    public int getWallId() {
        return this.wallid;
    }

    @Override
    public void setWallId(int wallId) {
        this.wallid=wallId;
    }

    @Override
    public List<ReactionAbstract> getReactions() {
        List<ReactionAbstract>reactionAbstracts = new ArrayList<ReactionAbstract>(0);
        for (Reaction reaction: this.reactions){
            reactionAbstracts.add(reaction);
        }
        return reactionAbstracts;
    }

    @Override
    public void setReactions(List<ReactionAbstract> reactions) {
        for (ReactionAbstract reactionAbstract: reactions){
            this.reactions.add((Reaction) reactionAbstract);
        }
    }
}
