package DAL.Oracle;

import DAL.Common.AddressAbstract;
import oracle.jdbc.driver.OracleConnection;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

@MappedTypes({Address.class, AddressAbstract.class})
public class AddressTypeHandler extends BaseTypeHandler<Object> {
    private static final int SQL_TYPE = Types.STRUCT;
    private static final String OBJECT_TYPE = "ADDRESS";
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        if (o == null) {
            preparedStatement.setNull(i, SQL_TYPE, OBJECT_TYPE);
        }
        else {
            final Address addresssData = (Address) o;
            final Object[] values = new Object[] {addresssData.getStreetNbr(), addresssData.getCityName(), addresssData.getZipCode()};
            final OracleConnection connection = (OracleConnection) preparedStatement.getConnection();
            StructDescriptor sdesc = StructDescriptor.createDescriptor(OBJECT_TYPE, connection);
            final STRUCT struct = new STRUCT(sdesc, connection, values);
            preparedStatement.setObject(i, struct, SQL_TYPE);
        }
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Address address = new Address();
        Struct javaStruct = (Struct) callableStatement.getObject(i);

        Object[] attributes = javaStruct.getAttributes();
        address.setStreetNbr(Integer.valueOf(attributes[0].toString()));
        address.setCityName(attributes[1].toString());
        address.setZipCode(Integer.valueOf(attributes[2].toString()));
        return address;
    }
}
