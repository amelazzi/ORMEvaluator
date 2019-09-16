package DAL.Entities.MySQL;

import DAL.Entities.Common.MessageAbstract;
import DAL.Entities.Common.UserAbstract;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="message")
public class Message extends MessageAbstract {
    private Date sendingDate;
    private boolean seen;
    private String text;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Message(){super();}

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id){
    }

    @Override
    public Date getSendingDate() {
        return this.sendingDate;
    }

    @Override
    public void setSendingDate(Date sendingDate) {
        this.sendingDate=sendingDate;
    }

    @Override
    public boolean isSeen() {
        return this.seen;
    }

    @Override
    public void setSeen(boolean seen) {
        this.seen=seen;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text=text;
    }

    @Override
    public UserAbstract getUser() {
        return this.user;
    }

    @Override
    public void setUser(UserAbstract user) {
        this.user = (User) user;
    }

}
