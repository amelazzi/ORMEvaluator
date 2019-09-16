package Tests;

import DAL.Entities.Common.UserAbstract;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.IFetchTest;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HqlFetchTest implements IFetchTest {
    public DBName dbName;
    public Session session;

    public HqlFetchTest(DBName dbName, Session session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long selectById() {
        //Select User

        long startNanos = System.nanoTime();
        this.session.createQuery("From User WHERE ID=321");

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectAll() {
        // Select all from User

        long startNanos = System.nanoTime();

        List rows = this.session.createQuery("From User ").list();
        System.out.println("size: " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithConstraints() {
        //Select Female Users

        long startNanos = System.nanoTime();
        List rows = this.session.createQuery("From User where sexe='Female'").list();
        System.out.println("size: " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }


    @Override
    public long selectWithJoins() {
        //Select User having published pictures

        long startNanos = System.nanoTime();

        List rows = this.session.createQuery("select user " +
                "from User user,Publication publication, Picture picture " +
                "where publication.id=picture.id and user.id=picture.user.id").list();

        System.out.println("size: " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoinsGroupBy() {
        // Select Reactions Number by Sexe

        long startNanos = System.nanoTime();

        List rows = this.session.createQuery("select user.sexe, count(user.id) " +
                "from User user,Publication publication, Reaction reaction " +
                "where user.id=publication.user.id and user.id=reaction.user.id and reaction.publication.id=publication.id " +
                "group by user.sexe " +
                "order by count (user.id) desc").list();
        System.out.println("size: " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

}
