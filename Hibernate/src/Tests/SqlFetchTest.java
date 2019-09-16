package Tests;

import DAL.Entities.Common.UserAbstract;
import DAL.Entities.PostgreSQL.User;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.IFetchTest;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SqlFetchTest implements IFetchTest {
    public DBName dbName;
    public Session session;

    public SqlFetchTest(DBName dbName, Session session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long selectById() {
        String query="";
        if(this.dbName==DBName.PostgreSQL)
            query = "SELECT * FROM \"public\".\"user\", \"public\".userinfo WHERE \"user\".id=userinfo.userid and \"user\".id=1311";
        if(this.dbName==DBName.MySQL)
            query = "select * from mysqldb.user, mysqldb.userinfo where user.id=userinfo.userid and user.id=1311";
        if(this.dbName==DBName.Oracle)
            query="";

        long startNanos = System.nanoTime();

        List rows = this.session.createSQLQuery("select * from UTILISATOR, MACOS.USERINFO where UTILISATOR..id = USERINFO.USERID and UTILISATOR.ID=1311").list();
        System.out.println("size : " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectAll() {
        String query="";
        if(this.dbName==DBName.PostgreSQL)
            query = "SELECT * FROM \"user\"";
        if (this.dbName==DBName.MySQL)
            query="select * from mysqldb.user";
        if(this.dbName==DBName.Oracle)
            query="select * from UTILISATOR";

        long startNanos = System.nanoTime();

        List rows  = this.session.createSQLQuery(query).list();
        System.out.println("size: " + rows.size());


        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithConstraints() {
        String query="";
        if(this.dbName==DBName.PostgreSQL)
            query = "select userinfo.sexe from \"public\".userinfo userinfo, \"user\" u " +
                    "where u.id=userinfo.userid and userinfo.sexe='Female'";
        if (this.dbName==DBName.MySQL)
            query="select * from mysqldb.user, mysqldb.userinfo where user.id=userinfo.userid and userinfo.sexe='Female'";
        if (this.dbName==DBName.Oracle)
            query="select * from UTILISATOR, MACOS.USERINFO where UTILISATOR.id=USERINFO.userid and USERINFO.sexe='Female'";

        long startNanos = System.nanoTime();

        SQLQuery sqlQuery = this.session.createSQLQuery(query);
        List rows = sqlQuery.list();
        System.out.println("size : " + rows.size());
        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoins() {
        String query="";
        if(this.dbName==DBName.PostgreSQL)
            query = "select u.id as utilisatorID from \"user\" u" +
                    ",(select * from \"public\".publication, \"public\".picture " +
                    "   where \"public\".publication.id=\"public\".picture.publicationid and picture.extension='png')as b " +
                    "where u.id=b.userid";
        if (this.dbName==DBName.MySQL)
            query="select u.id as utilisatorID from mysqldb.user u" +
                    ", (select * from mysqldb.publication, mysqldb.picture " +
                    "   where publication.id=picture.publicationid and picture.extension='png')as b " +
                    "where u.id=b.userid";
        if (this.dbName==DBName.Oracle)
            query="select u.id as utilisatorID from UTILISATOR u" +
                    ", (select * from MACOS.PUBLICATION, MACOS.PICTURE" +
                    "   where PUBLICATION.ID=PICTURE.PUBLICATIONID and PICTURE.EXTENSION='png')as b " +
                    "where u.id=b.userid";

        long startNanos = System.nanoTime();

        List rows  = this.session.createSQLQuery(query).list();
        System.out.println("size : " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoinsGroupBy() {
        String query="";
        if(this.dbName==DBName.PostgreSQL)
            query = "select userinfo.sexe, count(userinfo.userid) " +
                    "from \"public\".userinfo userinfo, \"public\".publication publication, \"public\".reaction reaction " +
                    "where userinfo.userid=publication.userid and userinfo.userid=reaction.userid and publication.id=reaction.publicationid " +
                    "group by userinfo.sexe " +
                    "order by count(userinfo.userid)";
        if(this.dbName==DBName.MySQL)
            query="select userinfo.sexe, count(userinfo.userid) " +
                    "from mysqldb.userinfo userinfo, mysqldb.publication publication, mysqldb.reaction reaction " +
                    "where userinfo.userid=publication.userid and userinfo.userid=reaction.userid and publication.id=reaction.publicationid " +
                    "group by userinfo.sexe " +
                    "order by count(userinfo.userid)";
        if(this.dbName==DBName.Oracle)
            query="select userinfo.sexe, count(userinfo.userid) " +
                    "from MACOS.USERINFO userinfo, MACOS.PUBLICATION publication, MACOS.REACTION reaction " +
                    "where userinfo.userid=publication.userid and userinfo.userid=reaction.userid and publication.id=reaction.publicationid " +
                    "group by userinfo.sexe " +
                    "order by count(userinfo.userid)";

        long startNanos = System.nanoTime();

        List rows = this.session.createSQLQuery(query).list();
        System.out.println("size : " + rows.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }
}
