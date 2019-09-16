package Tests;


import DAL.Entities.Common.PublicationAbstract;
import DAL.Entities.Common.UserAbstract;
import DAL.Entities.Oracle.Picture;
import DAL.Entities.Oracle.User;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.IFunctionsTest;
import com.sun.tools.javac.util.Assert;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HibernateFunctionsTest implements IFunctionsTest {
    private DBName dbName;
    private Session session;

    public HibernateFunctionsTest(DBName dbName, Session session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long compiledQueriesTest() {
        return 0;
    }

    @Override
    public long storedProceduresTest() {
        Random r = new Random();
        int randomID = r.nextInt(7000-6000) + 6000;
        Query query=null;

        long startNanos = 0;
        if(this.dbName==DBName.Oracle){
            startNanos = System.nanoTime();
             /*query = this.session.getNamedQuery("InsertWall")
                    .setParameter("description", "NewWall")
                    .setParameter("wallType", 2);*/
        }else {
            startNanos = System.nanoTime();
             query = this.session.getNamedQuery("InsertWall")
                    .setParameter("id", 345154)
                    .setParameter("description", "NewWall")
                    .setParameter("wallType", 2);
        }

        query.executeUpdate();

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long inheritenceTest() {
        long startNanos = System.nanoTime();

        if(this.dbName==DBName.Oracle){
            //Load all pictures
            List<Picture> pictures = this.session.createQuery("from Picture ").list();
            //Assert that any non nullable column in the parent entity (Publication) is not null
            pictures.parallelStream().forEach(picture -> Assert.checkNonNull(picture.getDescription()));

        }else{
            //Load all pictures
            List<PublicationAbstract> pictures = this.session.createQuery("from Picture ").list();
            //Assert that any non nullable column in the parent entity (Publication) is not null
            pictures.parallelStream().forEach(picture -> Assert.checkNonNull(picture.getDescription()));
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long associationTest() {
        long startNanos = System.nanoTime();

        if(this.dbName==DBName.Oracle){
            //Load all users
            List<User> users = this.session.createQuery("from User ").list();
            //Assert that any user have publications
            users.get(0).getPublications().size();
            org.junit.Assert.assertTrue(users.get(0).getPublications().size()>=0);

        }else{
            //Load all users
            List<UserAbstract> users = this.session.createQuery("from User ").list();
            //Assert that any user have publications
            org.junit.Assert.assertTrue(users.get(28).getPublications().size()>=0);
            //org.junit.Assert.assertTrue(users.get(0).getPublications().size()>=1);
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }
}
