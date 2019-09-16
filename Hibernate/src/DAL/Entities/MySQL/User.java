package DAL.Entities.MySQL;

import DAL.Entities.Common.*;
import DAL.Entities.PostgreSQL.PostgreSQLEnumType;
import com.company.Common.Enums.Sexe;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TypeDef(
        name = "sexe_enum",
        typeClass = PostgreSQLEnumType.class
)


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="userType",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@Table(name = "\"user\"")
@SecondaryTable(name = "userinfo", pkJoinColumns = @PrimaryKeyJoinColumn(name = "userid"))
public class User extends UserAbstract {
    @Id
    @GeneratedValue
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String pwd;

    @Column(columnDefinition = "dateofbirth", table = "userinfo")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "sexe", table = "userinfo")
    private Sexe sexe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", table = "userinfo", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<Message>(0);

    @OneToMany(mappedBy = "user")
    private List<Publication> publications = new ArrayList<Publication>(0);

    @OneToMany(mappedBy = "user")
    private List<Reaction> reactions = new ArrayList<Reaction>(0);

    @ManyToMany
    @JoinTable(name="user_user",
            joinColumns=@JoinColumn(name="userid1"),
            inverseJoinColumns=@JoinColumn(name="userid2")
    )
    private List<User> friends = new ArrayList<User>(0);

    @ManyToMany
    @JoinTable(name="user_user",
            joinColumns=@JoinColumn(name="userid2"),
            inverseJoinColumns=@JoinColumn(name="userid1")
    )
    private List<User> friendOf = new ArrayList<User>(0);;

    public User(){super();}

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID=ID;
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
        this.address =(Address) addressAbstract;
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
            this.messages.add((Message) messageAbstract);
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
        for (PublicationAbstract publicationAbstract: publications){
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


    public void rmFriend(User friend) {
        friends.remove(friend);
        friend.getFriendOf().remove(this);
    }

    public void removeFriend() {
        for(User friend : new ArrayList<>(friends)) {
            rmFriend(friend);
        }
    }

    public void rmFriendOf(User friend) {
        friendOf.remove(friend);
        friend.getFriends().remove(this);
    }

    public void removeFriendOf() {
        for(User friend : new ArrayList<>(friendOf)) {
            rmFriendOf(friend);
        }
    }

}
