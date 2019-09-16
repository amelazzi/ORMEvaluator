package DAL.DataTypes;

import oracle.jdbc.OracleConnection;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;


public class AddressOracleType implements UserType {
    private static final int SQL_TYPE = Types.STRUCT;
    private static final String OBJECT_TYPE = "ADDRESS";
    @Override
    public int[] sqlTypes() {
        return new int[] {SQL_TYPE};
    }

    @Override
    public Class returnedClass() {
        return OracleAddress.class;
    }

    @Override
    public boolean equals(Object o1, Object o2) throws HibernateException {
        boolean isEqual = false;
        if (o1 == o2) {
            isEqual = true;
        }
        if (null == o1 || null == o2) {
            isEqual = false;
        } else {
            isEqual = o1.equals(o2);
        }
        return isEqual;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings,
                              SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException, SQLException {
        // owner here is class from where the call to retrieve data was made.
        // In this case the Test class
        final OracleAddress addresssData = new OracleAddress();

        final Struct struct = (Struct) resultSet.getObject(strings[0]);

        if (resultSet.wasNull()) {
            return null;
        }
        addresssData.setStreetNbr(Integer.valueOf(struct.getAttributes()[0].toString()));
        addresssData.setCityName((String)struct.getAttributes()[1]);
        addresssData.setZipCode(Integer.valueOf(struct.getAttributes()[0].toString()));

        return addresssData;

    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i,
                            SharedSessionContractImplementor sharedSessionContractImplementor)
            throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setNull(i, SQL_TYPE, OBJECT_TYPE);
        }
        else {
            final OracleAddress addresssData = (OracleAddress) o;
            System.out.println("Before" + addresssData);
            final Object[] values = new Object[] { addresssData.getStreetNbr(),addresssData.getCityName(),
                    addresssData.getZipCode()};
            final OracleConnection connection = (OracleConnection) preparedStatement.getConnection();
            StructDescriptor sdesc = StructDescriptor.createDescriptor(OBJECT_TYPE, connection);
            final STRUCT struct = new STRUCT(sdesc, connection, values);
            preparedStatement.setObject(i, struct, SQL_TYPE);

            System.out.println("After" + addresssData);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return null;
    }


    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner) throws HibernateException {
        return null;
    }

}
