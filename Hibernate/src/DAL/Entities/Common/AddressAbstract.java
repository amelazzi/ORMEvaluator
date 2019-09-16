package DAL.Entities.Common;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class AddressAbstract {
    @Id
    @GeneratedValue
    private int id;

    public AddressAbstract() {
    }

    public abstract int getId();
    public abstract void setId(int id);
    public abstract void setStreetNbr(int streetNbr);
    public abstract int getStreetNbr();
    public abstract void setCityName(String cityName);
    public abstract String getCityName();
    public abstract void setZipCode(int zipCode);
    public abstract int getZipCode();
    public abstract UserAbstract getUser();
    public abstract void setUser(UserAbstract userAbstract);
}
