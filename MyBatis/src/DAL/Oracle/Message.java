package DAL.Oracle;

import DAL.Common.MessageAbstract;

import java.util.Date;


public class Message extends MessageAbstract {
    private int Id;
    private Date sendingDate;
    private boolean seen;
    private String text;
    private int userid;

    public Message(){super();}

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public void setId(int id) {
        this.Id=id;
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
    public int getUserId() {
        return this.userid;
    }

    @Override
    public void setUserId(int userId) {
        this.userid=userId;
    }

}
