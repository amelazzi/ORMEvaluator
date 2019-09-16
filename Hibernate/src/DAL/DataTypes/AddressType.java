package DAL.DataTypes;



import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class AddressType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.OTHER};
    }

    @Override
    public Class returnedClass() {
        return Address.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings,
                              SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException, SQLException {
        if (resultSet.wasNull()) return null;
        else{
            String address = resultSet.getString(strings[0]);
            address = address.substring(1,address.length()-1);

            String[] addressData = address.split(",");

            final Address newAddress = new Address();
            newAddress.setStreetNbr(Integer.valueOf(addressData[0]));
            newAddress.setCityName(addressData[1]);
            newAddress.setZipCode(Integer.valueOf(addressData[2]));

            return newAddress;
        }

    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i,
                            SharedSessionContractImplementor sharedSessionContractImplementor)
            throws HibernateException, SQLException {

        if(o == null) {
            preparedStatement.setNull(i, Types.OTHER, "address_type");
        } else {
            final Address address = (Address) o;
            preparedStatement.setObject(i, address.toString(), Types.OTHER);
//          IntegerType.INSTANCE.set(st, nillable.getValue(), index, session);
//          StringType.INSTANCE.set(st, nillable.getNill(), index + 1, session);
        }

    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        if (o == null) return null;

        Address address = (Address) o;
        Address newAddress = new Address();
        newAddress.setStreetNbr(address.getStreetNbr());
        newAddress.setCityName(address.getCityName());
        newAddress.setZipCode(address.getZipCode());

        return newAddress;

    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return o;
    }
}
