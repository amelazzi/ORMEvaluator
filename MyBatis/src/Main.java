
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;


public class Main {
    public static void main(final String[] args) throws IOException, ParseException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream, "MyBatis_PostgreSQL");
        SqlSession session = sqlSessionFactory.openSession();

        System.out.print("helo from my batis");

       session.commit();
       session.close();

    }
}
