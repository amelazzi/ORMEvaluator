package DAL.Common;


import com.company.Common.Enums.ReactionType;

import java.util.Date;


public abstract class ReactionAbstract {


    public  ReactionAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract Date getReactionDate();

    public abstract void setReactionDate(Date reactionDate);

    public abstract ReactionType getType();

    public abstract void setType(ReactionType type);

    public abstract int getUserId();

    public abstract void setUserId(int i);

    public abstract int getPublicationId();

    public abstract void setPublicationId(int i);

}
