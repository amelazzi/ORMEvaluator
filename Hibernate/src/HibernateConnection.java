import com.company.*;
import com.company.Common.Enums.DBName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateConnection {
    private DBName dbName;

    public HibernateConnection(DBName dbName) {
        this.dbName = dbName;
    }

    public Session getSession(){
        File configFile = null;
        Configuration configuration = new Configuration();
        if (this.dbName==DBName.Oracle){
            configFile = new File("/Users/macos/Desktop/ORMEvaluator/Hibernate/resources/hibernateOracle.cfg.xml");
        }
        if (this.dbName==DBName.MySQL){
            configFile = new File("/Users/macos/Desktop/ORMEvaluator/Hibernate/resources/hibernateMySQL.cfg.xml");
        }
        if (this.dbName==DBName.PostgreSQL){
            configFile = new File("/Users/macos/Desktop/ORMEvaluator/Hibernate/resources/hibernatePostgres.cfg.xml");
        }
        SessionFactory sessionFactory = configuration.configure(configFile).buildSessionFactory();

        return sessionFactory.openSession();
    }

    public void closeSession(Session session){
        session.getTransaction().commit();
        session.close();
    }

}
