package DAL.PostgreSQL;


import DAL.Common.*;
import com.company.Common.Enums.Sexe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends UserAbstract {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String pwd;
    private Date dateOfBirth;
    private Sexe sexe;
    private Address address;
    private int userType;
    private List<Message> messages = new ArrayList<Message>(0);
    private List<Publication> publications = new ArrayList<Publication>(0);
    private List<Reaction> reactions = new ArrayList<Reaction>(0);
    private List<User> friends = new ArrayList<User>(0);
    private List<User> friendOf = new ArrayList<User>(0);


    public User(){super();}

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int ID) {
        this.id=ID;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email=email;
    }

    @Override
    public String getPwd() {
        return this.pwd;
    }

    @Override
    public void setPwd(String pwd) {
        this.pwd=pwd;
    }

    @Override
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }

    @Override
    public Sexe getSexe() {
        return this.sexe;
    }

    @Override
    public void setSexe(Sexe sexe) {
        this.sexe=sexe;
    }

    @Override
    public AddressAbstract getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(AddressAbstract addressAbstract) {
        this.address = (Address) addressAbstract;
    }

    @Override
    public DAL.MySQL.Address getAddressMySQL() {
        return null;
    }

    @Override
    public void setAddressMySQL(DAL.MySQL.Address address) {

    }

    @Override
    public List<MessageAbstract> getMessages() {
        List<MessageAbstract>messageAbstracts = new ArrayList<MessageAbstract>(0);
        for (Message message: this.messages){
            messageAbstracts.add(message);
        }
        return messageAbstracts;
    }

    @Override
    public void setMessages(List<MessageAbstract> messages) {
        for (MessageAbstract messageAbstract: messages){
            this.messages.add((Message)messageAbstract);
        }
    }

    @Override
    public List<PublicationAbstract> getPublications() {
        List<PublicationAbstract>publicationAbstracts = new ArrayList<PublicationAbstract>(0);
        for (Publication publication: this.publications){
            publicationAbstracts.add(publication);
        }
        return publicationAbstracts;
    }

    @Override
    public void setPublications(List<PublicationAbstract> publicationAbstracts) {
        for (PublicationAbstract publicationAbstract: publicationAbstracts){
            this.publications.add((Publication) publicationAbstract);
        }
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

    @Override
    public List<UserAbstract> getFriends() {
        List<UserAbstract>userAbstracts = new ArrayList<UserAbstract>(0);
        for (User friend: this.friends){
            userAbstracts.add(friend);
        }
        return userAbstracts;
    }

    @Override
    public void setFriends(List<UserAbstract> friends) {
        for (UserAbstract userAbstract: friends){
            this.friends.add((User) userAbstract);
        }
    }

    @Override
    public List<UserAbstract> getFriendOf() {
        List<UserAbstract>userAbstracts = new ArrayList<UserAbstract>(0);
        for (User friendOf: this.friendOf){
            userAbstracts.add(friendOf);
        }
        return userAbstracts;
    }

    @Override
    public void setFriendOf(List<UserAbstract> friendOf) {
        for (UserAbstract userAbstract: friendOf){
            this.friendOf.add((User) userAbstract);
        }
    }

}
