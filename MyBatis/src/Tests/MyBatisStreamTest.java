package Tests;

import DAL.Common.UserAbstract;
import com.company.Common.Enums.DBName;
import com.company.Common.Enums.Sexe;
import com.company.Common.TestCategories.IStreamTest;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MyBatisStreamTest implements IStreamTest {
    private DBName dbName;
    private SqlSession session;

    public MyBatisStreamTest(DBName dbName, SqlSession session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long selectById() {
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

        List<UserAbstract> usersList = this.session.selectList(query);
        StreamSupport.stream(usersList.spliterator(), false)
                .filter(user -> user.getID()==6180);
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

        List usersList = this.session.selectList(query);
        StreamSupport.stream(usersList.spliterator(), true)
                .collect(Collectors.toList());
        System.out.println("size: "+usersList.size());


        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;

    }

    @Override
    public long selectWithConstraints() {
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

        List<UserAbstract> usersList = this.session.selectList(query);
        StreamSupport.stream(usersList.spliterator(), true)
                .filter(user -> user.getSexe()== Sexe.Female)
                .collect(Collectors.toList());

        System.out.println("size: "+usersList.size());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoins() {
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


        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long selectWithJoinsGroupBy() {
        return 0;
    }
}
