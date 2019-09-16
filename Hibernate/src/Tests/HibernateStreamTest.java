package Tests;


import DAL.Entities.Common.UserAbstract;
import DAL.Entities.Oracle.User;
import com.company.Common.Enums.DBName;
import com.company.Common.Enums.Sexe;
import com.company.Common.TestCategories.IStreamTest;
import org.hibernate.Session;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class HibernateStreamTest implements IStreamTest {
    public DBName dbName;
    public Session session;

    public HibernateStreamTest(DBName dbName, Session session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long selectById() {

        long startNanos = System.nanoTime();

        if (this.dbName==DBName.Oracle){
            this.session.createQuery("FROM User ", User.class).stream()
                    .filter(user -> user.getID() == 321);

        }else{
            this.session.createQuery("FROM User ", UserAbstract.class).stream()
                    .filter(user -> user.getID() == 1311);
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectAll() {
        // Select all from User
        long startNanos = System.nanoTime();

        if (this.dbName==DBName.Oracle){
            List<User>users = this.session.createQuery("From User", User.class).stream()
                    .collect(Collectors.toList());
        }else{
            this.session.createQuery("From User", UserAbstract.class).stream()
                    .collect(Collectors.toList());
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithConstraints() {
        //Select Female Users

        long startNanos = System.nanoTime();

        if (this.dbName==DBName.Oracle){
            List<User> users= this.session.createQuery("From User", User.class).stream()
                    .filter(user -> user.getSexe()== Sexe.Female).collect(Collectors.toList());

        }else{
            this.session.createQuery("From User", UserAbstract.class).stream()
                    .filter(user -> user.getSexe()== Sexe.Female).collect(Collectors.toList());
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoins() {
        //Select User having published pictures
        long startNanos = System.nanoTime();


        //System.out.println("size : " + query.size());
        //List query =  this.session.createQuery("").stream().collect(Collectors.toList());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoinsGroupBy() {
        return 0;
    }
}
