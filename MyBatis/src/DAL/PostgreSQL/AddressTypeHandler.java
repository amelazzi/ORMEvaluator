package DAL.PostgreSQL;

import DAL.Common.AddressAbstract;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({Address.class, AddressAbstract.class})

public class AddressTypeHandler extends BaseTypeHandler<Object> {
    private static final PGobject addressObject = new PGobject();
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int columnIndex, Object o, JdbcType jdbcType) throws SQLException {
        Address obj = (Address) o;
        addressObject.setType("address");
        addressObject.setValue("(" + obj.getStreetNbr() + "," + obj.getCityName() + "," + obj.getZipCode() + ")");
        preparedStatement.setObject(columnIndex, addressObject);
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
    public Object getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        PGobject pgObj = (PGobject) callableStatement.getObject( columnIndex);
        if (! "address".equals( pgObj.getType())) throw new SQLException( "invalid object type; expected my_sql_type; got: " + pgObj.getType());
        String[] values = pgObj.getValue().substring( 1, pgObj.getValue().length() - 1).split( ",");
        Address obj = new Address();
        obj.setStreetNbr(Integer.valueOf(values[0]));
        obj.setCityName(values[1]);
        obj.setZipCode(Integer.valueOf(values[2]));
        return (Object) obj;
    }
}
