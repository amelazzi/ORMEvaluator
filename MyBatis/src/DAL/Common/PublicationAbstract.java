package DAL.Common;


import java.util.Date;
import java.util.List;

public abstract class PublicationAbstract {

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

    public abstract int getUserId();

    public abstract void setUserId(int userId);

    public abstract int getWallId();

    public abstract void setWallId(int wallId);

    public abstract List<ReactionAbstract> getReactions();

    public abstract void setReactions(List<ReactionAbstract> reactions);


}
