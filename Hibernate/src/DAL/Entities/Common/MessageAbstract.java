package DAL.Entities.Common;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class MessageAbstract {
    @Id
    @GeneratedValue
    private int id;

    public MessageAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract Date getSendingDate();

    public abstract void setSendingDate(Date sendingDate);

    public abstract boolean isSeen();

    public abstract void setSeen(boolean seen);

    public abstract String getText();

    public abstract void setText(String text);

    public abstract UserAbstract getUser();

    public abstract void setUser(UserAbstract user);
}
