package Tests;

import DAL.Common.UserAbstract;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.IFetchTest;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyBatisFetchTest implements IFetchTest {
    private DBName dbName;
    private SqlSession session;

    public MyBatisFetchTest(DBName dbName, SqlSession session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long selectById() {
        String query = "";
        if(this.dbName== DBName.PostgreSQL){
            query = "DAL.PostgreSQL.User.getById";
        }else{
            if(this.dbName==DBName.MySQL){
                query = "DAL.MySQL.User.getById";
            }else {
                query = "DAL.Oracle.User.getById";
            }
        }

        long startNanos = System.nanoTime();

        UserAbstract user = this.session.selectOne(query, 321);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectAll() {
        String query = "";
        if(this.dbName== DBName.PostgreSQL){
            query = "DAL.PostgreSQL.User.getAll";
        }else{
            if(this.dbName==DBName.MySQL){
                query = "DAL.MySQL.User.getAll";
            }else {
                query = "DAL.Oracle.User.getAll";
            }
        }

        long startNanos = System.nanoTime();

        List<UserAbstract> users = this.session.selectList(query);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithConstraints() {
        String query = "";
        if(this.dbName== DBName.PostgreSQL){
            query = "DAL.PostgreSQL.User.getFemale";
        }else{
            if(this.dbName==DBName.MySQL){
                query = "DAL.MySQL.User.getFemale";
            }else {
                query = "DAL.Oracle.User.getFemale";
            }
        }

        long startNanos = System.nanoTime();

        List users = this.session.selectList(query);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoins() {
        String query = "";
        if(this.dbName== DBName.PostgreSQL){
            query = "DAL.PostgreSQL.User.getUserPicture";
        }else{
            if(this.dbName==DBName.MySQL){
                query = "DAL.MySQL.User.getUserPicture";
            }else {
                query = "DAL.Oracle.User.getUserPicture";
            }
        }

        long startNanos = System.nanoTime();

        List users = this.session.selectList(query);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoinsGroupBy() {
        String query = "";
        if(this.dbName== DBName.PostgreSQL){
            query = "DAL.PostgreSQL.User.getReactionCount";
        }else{
            if(this.dbName==DBName.MySQL){
                query = "DAL.MySQL.User.getReactionCount";
            }else {
                query = "DAL.Oracle.User.getReactionCount";
            }
        }

        long startNanos = System.nanoTime();

        List users = this.session.selectList(query);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }
}
