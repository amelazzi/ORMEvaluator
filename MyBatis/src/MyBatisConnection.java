import com.company.Common.Enums.DBName;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConnection {
    private DBName dbName;

    public MyBatisConnection(DBName dbName){
        this.dbName = dbName;
    }

    public SqlSession getSession() throws IOException {
        String env ="";
        if (this.dbName==DBName.Oracle){
            env = "MyBatis_Oracle";
        }
        if (this.dbName==DBName.MySQL){
            env = "MyBatis_MySQL";
        }
        if (this.dbName==DBName.PostgreSQL){
            env = "MyBatis_PostgreSQL";
        }
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream, env);

        return sqlSessionFactory.openSession();
    }

    public void closeSession(SqlSession session){
        session.commit();
        session.close();
    }
}
