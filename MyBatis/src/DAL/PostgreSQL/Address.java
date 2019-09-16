package DAL.PostgreSQL;

import DAL.Common.AddressAbstract;

public class Address extends AddressAbstract {
    private int id;
    private int streetNbr;
    private String cityName;
    private int zipCode;

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

}
