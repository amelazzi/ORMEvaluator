package Tests;


import DAL.Entities.Common.UserAbstract;
import DAL.Entities.Oracle.User;
import DAL.Entities.PostgreSQL.Picture;
import com.company.Common.Enums.DBName;
import com.company.Common.Enums.Sexe;
import com.company.Common.TestCategories.IFetchTest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CriteriaFetchTest implements IFetchTest {
    public DBName dbName;
    public Session session;

    public CriteriaFetchTest(DBName dbName, Session session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long selectById() {
        //Select User
        Class classe = null;
        if (this.dbName==DBName.Oracle){
            classe = User.class;
        }else{
            classe = UserAbstract.class;
        }

        long startNanos = System.nanoTime();

        List list = this.session.createCriteria(classe)
                .add(Restrictions.eq("id", 321)).list();

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectAll() {

        Class classe = null;
        if (this.dbName==DBName.Oracle){
            classe = User.class;
        }else{
            classe = UserAbstract.class;
        }

        long startNanos = System.nanoTime();

        List list = this.session.createCriteria(classe).list();

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithConstraints() {
        //Select Female Users
        Class classe = null;
        if (this.dbName==DBName.Oracle){
            classe = User.class;
        }else{
            classe = UserAbstract.class;
        }

        long startNanos = System.nanoTime();

        List list = this.session.createCriteria(classe)
                .add(Restrictions.eq("sexe", Sexe.Female)).list();

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;

    }

    @Override
    public long selectWithJoins() {

        Class classe = null;
        Class pictureClass= null;
        if (this.dbName==DBName.Oracle){
            classe = User.class;
            pictureClass = DAL.Entities.Oracle.Picture.class;
        }else{
            classe = UserAbstract.class;
            if(this.dbName==DBName.PostgreSQL) pictureClass = Picture.class;
            if(this.dbName==DBName.MySQL) pictureClass = DAL.Entities.MySQL.Picture.class;
        }

        long startNanos = System.nanoTime();

        List list = this.session.createCriteria(classe)
                .createCriteria("publications")
                .add(Restrictions.eq("class", pictureClass)).list();


        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoinsGroupBy() {

        Class classe = null;
        if (this.dbName==DBName.Oracle){
            classe = User.class;
        }else{
            classe = UserAbstract.class;
        }

        long startNanos = System.nanoTime();

        List list = this.session.createCriteria(classe)
                .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("sexe"))
                    .add(Projections.count("id")))
                .createCriteria("publications")
                .createCriteria("reactions").list();

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }
}
