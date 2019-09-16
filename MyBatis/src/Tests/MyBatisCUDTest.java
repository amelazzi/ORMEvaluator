package Tests;

import DAL.Common.MessageAbstract;
import DAL.Common.WallAbstract;
import DAL.PostgreSQL.Message;
import DAL.PostgreSQL.Page;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.ICUDTest;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class MyBatisCUDTest implements ICUDTest {
    private DBName dbName;
    private SqlSession session;

    public MyBatisCUDTest(DBName dbName, SqlSession session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long insertBulk() throws ParseException {
        //Insert a bulk of Wall
        WallAbstract wall = null;
        String query="";
        if(this.dbName==DBName.PostgreSQL){
            wall = new Page();
            query = "DAL.PostgreSQL.Page.insert";
        }else{
            if(this.dbName==DBName.MySQL){
                wall = new DAL.MySQL.Page();
                query = "DAL.MySQL.Page.insert";
            }else{
                wall = new DAL.Oracle.Page();
                query = "DAL.Oracle.Page.insert";
            }
        }

        long startNanos = System.nanoTime();
        for(int i=0; i<50; i++){
            wall.setId(i+55050);
            wall.setDescription("new wall");
            this.session.insert(query, wall);
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long insertSingle() {
        //Insert Wall
        Random r = new Random();
        int result = r.nextInt(6000-5000) + 5000;
        WallAbstract wall = null;
        String query="";
        if(this.dbName==DBName.PostgreSQL){
            wall = new Page();
            query = "DAL.PostgreSQL.Page.insert";
        }else{
            if(this.dbName==DBName.MySQL){
                wall = new DAL.MySQL.Page();
                query = "DAL.MySQL.Page.insert";
            }else {
                wall = new DAL.Oracle.Page();
                query = "DAL.Oracle.Page.insert";
            }
        }

        long startNanos = System.nanoTime();

        wall.setId(result);
        wall.setDescription("new wall");
        this.session.insert(query, wall);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long updateBulk() {

        MessageAbstract message;
        String queryGet = "";
        String queryUpdate = "";
        if(this.dbName==DBName.PostgreSQL){
            message = new Message();
            queryGet = "DAL.PostgreSQL.Message.getAll";
            queryUpdate = "DAL.PostgreSQL.Message.update";
        }else{
            if(this.dbName==DBName.MySQL){
                message = new DAL.MySQL.Message();
                queryGet = "DAL.MySQL.Message.getAll";
                queryUpdate = "DAL.MySQL.Message.update";
            }else{
                message = new DAL.Oracle.Message();
                queryGet = "DAL.Oracle.Message.getAll";
                queryUpdate = "DAL.Oracle.Message.update";
            }
        }

        List<MessageAbstract> messages = this.session.selectList(queryGet);
        long startNanos = System.nanoTime();
        for(int i=0; i<50; i++){
            messages.get(i).setText("updated Text");
            this.session.update(queryUpdate, messages.get(i));
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long upddateSingle() {
        MessageAbstract message;
        String queryGet = "";
        String queryUpdate = "";
        if(this.dbName==DBName.PostgreSQL){
            message = new Message();
            queryGet = "DAL.PostgreSQL.Message.getById";
            queryUpdate = "DAL.PostgreSQL.Message.update";
        }else{
            if(this.dbName==DBName.MySQL){
                message = new DAL.MySQL.Message();
                queryGet = "DAL.MySQL.Message.getById";
                queryUpdate = "DAL.MySQL.Message.update";
            }else{
                message = new DAL.Oracle.Message();
                queryGet = "DAL.Oracle.Message.getById";
                queryUpdate = "DAL.Oracle.Message.update";
            }
        }


        long startNanos = System.nanoTime();

        message = this.session.selectOne(queryGet, 50000);
        message.setText("Update text");
        this.session.update(queryUpdate, message);

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long deleteBulk() {
        String queryGet = "";
        String queryDelete = "";

        if(this.dbName==DBName.PostgreSQL){
            queryGet = "DAL.PostgreSQL.Message.getAll";
            queryDelete = "DAL.PostgreSQL.Message.deleteById";
        }else{
            if(this.dbName==DBName.MySQL){
                queryGet = "DAL.MySQL.Message.getAll";
                queryDelete = "DAL.MySQL.Message.deleteById";
            }else{
                queryGet = "DAL.Oracle.Message.getAll";
                queryDelete = "DAL.Oracle.Message.deleteById";
            }
        }


        List<MessageAbstract> messages = this.session.selectList(queryGet);
        long startNanos = System.nanoTime();
        for(int i=0; i<50  ; i++){
            this.session.update(queryDelete, messages.get(i).getId());
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long deleteSingle() {

        String queryGet = "";
        String queryDelete = "";
        if(this.dbName==DBName.PostgreSQL){
            queryGet = "DAL.PostgreSQL.Message.getAll";
            queryDelete = "DAL.PostgreSQL.Message.deleteById";
        }else{
            if(this.dbName==DBName.MySQL){
                queryGet = "DAL.MySQL.Message.getAll";
                queryDelete = "DAL.MySQL.Message.deleteById";
            }else{
                queryGet = "DAL.Oracle.Message.getAll";
                queryDelete = "DAL.Oracle.Message.deleteById";
            }
        }


        List<MessageAbstract> messages = this.session.selectList(queryGet);

        long startNanos = System.nanoTime();

        MessageAbstract message = messages.get(0);
        this.session.update(queryDelete, message.getId());

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }
}
