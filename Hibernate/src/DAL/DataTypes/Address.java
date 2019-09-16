package DAL.DataTypes;

import DAL.Entities.Common.AddressAbstract;
import DAL.Entities.Common.UserAbstract;

import java.io.Serializable;

public class Address extends AddressAbstract implements Serializable {
    private int streetNbr;
    private String cityName;
    private int zipCode;

    @Override
    public boolean equals(Object obj) {

        boolean isEqual = false;
        if (obj instanceof Address) {
            Address addressData = (Address) obj;

            isEqual = addressData.getStreetNbr()== this.getStreetNbr()
                    && addressData.getCityName().equals(this.getCityName())
                    && addressData.getZipCode()==this.getZipCode()
            ;
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        int hash = this.getStreetNbr();
        hash = hash * 17 + this.getCityName().hashCode();
        hash = hash * 31 + this.getZipCode();
        return hash;
    }

    @Override
    public String toString() {

        return "(" + streetNbr + "," + cityName + "," + zipCode + ")";

    }

    public Address(int streetNbr, String cityName, int zipCode) {
        this.streetNbr = streetNbr;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public Address(){
        super();
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

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
        return null;
    }

    @Override
    public void setUser(UserAbstract userAbstract) {

    }


}
