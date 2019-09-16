package DAL.Entities.Oracle;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue
    private int Id;
    private Date sendingDate;
    private boolean seen;
    private String text;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Message(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
