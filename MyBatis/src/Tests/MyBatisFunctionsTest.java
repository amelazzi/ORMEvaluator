package Tests;


import DAL.Common.PublicationAbstract;
import DAL.Common.UserAbstract;
import DAL.Common.WallAbstract;
import DAL.PostgreSQL.Page;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.IFunctionsTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyBatisFunctionsTest implements IFunctionsTest {
    private DBName dbName;
    private SqlSession session;

    public MyBatisFunctionsTest(DBName dbName, SqlSession session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long compiledQueriesTest() {
        return 0;
    }

    @Override
    public long storedProceduresTest() {
        String query="";
        WallAbstract page=null;
        if(this.dbName==DBName.PostgreSQL){
            query="DAL.PostgreSQL.Page.callInsertWall";
            page = new Page();
        }else{
            if(this.dbName==DBName.MySQL){
                query="DAL.MySQL.Page.callInsertWall";
                page = new DAL.MySQL.Page();
            }else{
                query="DAL.Oracle.Page.callInsertWall";
                page = new DAL.Oracle.Page();
            }
        }
        Random r = new Random();
        int result = r.nextInt(60500-55000) + 55000;
        page.setId(result);
        page.setDescription("PageFromProcedure");

        long startNanos = System.nanoTime();

        this.session.selectOne(query, page);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long inheritenceTest() {
        String query="";
        if(this.dbName==DBName.PostgreSQL){
            query="DAL.PostgreSQL.Picture.getAll";
        }else{
            if(this.dbName==DBName.MySQL){
                query="DAL.MySQL.Picture.getAll";
            }else{
                query="DAL.Oracle.Picture.getAll";
            }
        }

        long startNanos = System.nanoTime();

        List<PublicationAbstract> pictures = this.session.selectList(query);
        //Assert that any non nullable column in the parent entity (Publication) is not null
        pictures.parallelStream().forEach(picture -> Assert.assertNotNull(picture.getName()));

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long associationTest() {
        String query="";
        if(this.dbName==DBName.PostgreSQL){
            query="DAL.PostgreSQL.User.getAll";
        }else{
            if(this.dbName==DBName.MySQL){
                query="DAL.MySQL.User.getAll";
            }else{
                query="DAL.Oracle.User.getAll";
            }
        }

        long startNanos = System.nanoTime();

            //Load all users
            List<UserAbstract> users = this.session.selectList(query);
            //Assert that any user have publications
            users.get(0).getPublications().size();
            Assert.assertTrue(users.get(0).getPublications().size()>=0);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }
}
