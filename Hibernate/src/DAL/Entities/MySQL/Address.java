package DAL.Entities.MySQL;

import DAL.Entities.Common.AddressAbstract;
import DAL.Entities.Common.UserAbstract;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends AddressAbstract {
    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "streetnbr")
    private int streetNbr;
    @Column(columnDefinition = "cityname")
    private String cityName;
    @Column(columnDefinition = "zipcode")
    private int zipCode;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(int streetNbr, String cityName, int zipCode, User user) {
        this.streetNbr = streetNbr;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.user = user;
    }

    public Address(){super();}

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public void setStreetNbr(int streetNbr) {
        this.streetNbr=streetNbr;
    }

    @Override
    public int getStreetNbr() {
        return this.streetNbr;
    }

    @Override
    public void setCityName(String cityName) {
        this.cityName=cityName;
    }

    @Override
    public String getCityName() {
        return this.cityName;
    }

    @Override
    public void setZipCode(int zipCode) {
        this.zipCode=zipCode;
    }

    @Override
    public int getZipCode() {
        return this.zipCode;
    }

    @Override
    public UserAbstract getUser() {
        return this.user;
    }

    @Override
    public void setUser(UserAbstract userAbstract) {
        this.user = (User) userAbstract;
    }

}
