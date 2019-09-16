package DAL.Entities.Oracle;

import DAL.DataTypes.AddressOracleType;
import DAL.DataTypes.OracleAddress;
import DAL.Entities.PostgreSQL.PostgreSQLEnumType;
import com.company.Common.Enums.Sexe;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TypeDef(
        name = "Address_type",
        typeClass = AddressOracleType.class
)

@TypeDef(
        name = "sexe_enum",
        typeClass = PostgreSQLEnumType.class
)


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="userType",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@Table(name = "utilisator")
@SecondaryTable(name = "userinfo", pkJoinColumns = @PrimaryKeyJoinColumn(name = "userid"))
public class User{
    @Id
    @GeneratedValue
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String pwd;

    @Column(name = "dateofbirth", table = "userinfo")
    private Date dateOfBirth;

    //@Enumerated(EnumType.STRING)
    @Column(columnDefinition = "sexe", table = "userinfo")
    //@Type( type = "sexe_enum" )
    private Sexe sexe;

    @Column(columnDefinition = "address", table = "userinfo")
    @Type( type = "Address_type" )
    private OracleAddress address;

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
    private List<User> friendOf = new ArrayList<User>(0);


    public User(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public OracleAddress getAddress() {
        return address;
    }

    public void setAddress(OracleAddress address) {
        this.address = address;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(List<User> friendOf) {
        this.friendOf = friendOf;
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
