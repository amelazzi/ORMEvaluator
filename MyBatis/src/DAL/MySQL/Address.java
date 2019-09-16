package DAL.MySQL;

public class Address{

    private int id;
    private int streetNbr;
    private String cityName;
    private int zipCode;

    public Address (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreetNbr() {
        return streetNbr;
    }

    public void setStreetNbr(int streetNbr) {
        this.streetNbr = streetNbr;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
