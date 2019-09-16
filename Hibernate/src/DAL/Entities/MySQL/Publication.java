package DAL.Entities.MySQL;

import DAL.Entities.Common.PublicationAbstract;
import DAL.Entities.Common.ReactionAbstract;
import DAL.Entities.Common.UserAbstract;
import DAL.Entities.Common.WallAbstract;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publication")
@Inheritance(strategy = InheritanceType.JOINED)
public class Publication extends PublicationAbstract {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "wallid")
    private Wall wall;

    @OneToMany(mappedBy = "publication")
    private List<Reaction> reactions = new ArrayList<Reaction>(0);

    public Publication(){super();}

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
    public UserAbstract getUser() {
        return this.user;
    }

    @Override
    public void setUser(UserAbstract user) {
        this.user = (User) user;
    }

    @Override
    public WallAbstract getWall() {
        return this.wall;
    }

    @Override
    public void setWall(WallAbstract wall) {
        this.wall = (Wall) wall;
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
            this.reactions.add((Reaction)reactionAbstract);
        }
    }


}
