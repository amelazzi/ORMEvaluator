package DAL.Common;

import java.util.Date;

public abstract class MessageAbstract {

    public MessageAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract Date getSendingDate();

    public abstract void setSendingDate(Date sendingDate);

    public abstract boolean isSeen();

    public abstract void setSeen(boolean seen);

    public abstract String getText();

    public abstract void setText(String text);

    public abstract int getUserId();

    public abstract void setUserId(int userId);
}
