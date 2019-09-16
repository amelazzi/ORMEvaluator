package DAL.Common;


import DAL.MySQL.Address;
import com.company.Common.Enums.Sexe;

import java.util.Date;
import java.util.List;


public abstract class UserAbstract {

    public UserAbstract(){}

    public abstract int getID();

    public abstract void setID(int ID);

    public abstract String getFirstName();

    public abstract void setFirstName(String firstName);

    public abstract String getLastName();

    public abstract void setLastName(String lastName);

    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract String getPwd();

    public abstract void setPwd(String pwd);

    public abstract Date getDateOfBirth();

    public abstract void setDateOfBirth(Date dateOfBirth);

    public abstract Sexe getSexe();

    public abstract void setSexe(Sexe sexe);

    public abstract AddressAbstract getAddress();

    public abstract void setAddress(AddressAbstract addressAbstract);

    public abstract Address getAddressMySQL();

    public abstract void setAddressMySQL(Address address);

    public abstract List<MessageAbstract> getMessages();

    public abstract void setMessages(List<MessageAbstract> messages);

    public abstract List<PublicationAbstract> getPublications();

    public abstract void setPublications(List<PublicationAbstract> publicationAbstracts);

    public abstract List<ReactionAbstract> getReactions();

    public abstract void setReactions(List<ReactionAbstract> reactions);

    public abstract List<UserAbstract> getFriends();

    public abstract void setFriends (List<UserAbstract> friends);

    public abstract List<UserAbstract> getFriendOf();

    public abstract void setFriendOf (List<UserAbstract> friendOf);


}
