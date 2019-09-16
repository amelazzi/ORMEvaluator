package DAL.Common;


public abstract class AddressAbstract {

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
}
