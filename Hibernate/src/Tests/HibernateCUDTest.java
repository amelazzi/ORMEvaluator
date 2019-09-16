package Tests;


import DAL.Entities.Common.MessageAbstract;
import DAL.Entities.Common.WallAbstract;
import DAL.Entities.Oracle.Message;
import DAL.Entities.Oracle.Page;
import DAL.Entities.Oracle.Wall;
import com.company.Common.Enums.DBName;
import com.company.Common.TestCategories.ICUDTest;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class HibernateCUDTest implements ICUDTest {
    public DBName dbName;
    public Session session;
    public int batchSize = 10;

    public HibernateCUDTest(DBName dbName, Session session) {
        this.dbName = dbName;
        this.session = session;
    }

    @Override
    public long insertBulk() throws ParseException {
        //Insert a bulk of Wall
        long startNanos = 0;
        //Query query = this.session.createQuery("From User");
        if(this.dbName==DBName.Oracle){
            startNanos = System.nanoTime();
            Wall wall = new Page();
            for(int i=0; i<50; i++){
                wall.setId(i+48000);
                wall.setDescription("new Wall");
                this.session.save(wall);
            }
        }else{
            startNanos = System.nanoTime();
            for(int i=0; i<50; i++){
                WallAbstract wall = null;
                if(this.dbName==DBName.PostgreSQL) wall = new DAL.Entities.PostgreSQL.Page();
                if(this.dbName==DBName.MySQL) wall = new DAL.Entities.MySQL.Page();
                wall.setId(i+49000);
                wall.setDescription("new Wall");
                this.session.save(wall);
            }
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long insertSingle() {
        //Insert Wall
        Random r = new Random();
        int result = r.nextInt(45000-35000) + 35000;
        long startNanos = System.nanoTime();
        if(this.dbName==DBName.Oracle){
            Wall wall = new Page();
            wall.setId(result);
            wall.setDescription("new Wall");
            this.session.save(wall);
        }else{
            WallAbstract wall = null;
            if(this.dbName==DBName.PostgreSQL) wall = new DAL.Entities.PostgreSQL.Page();
            if(this.dbName==DBName.MySQL) wall = new DAL.Entities.MySQL.Page();
            wall.setId(result);
            wall.setDescription("Higher National School");
            this.session.save(wall);
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long updateBulk() {
        //Update all of Users
        long startNanos = System.nanoTime();
        Query query = this.session.createQuery("From Message ");

        if(this.dbName==DBName.Oracle){
            List<Message> messages = query.list();
            for (int i=0; i<50; i++){
            /*if(i % this.batchSize == 0 && i > 0) {
                this.session.flush();
                this.session.clear();
            }*/
                messages.get(i).setText("update Text");
                this.session.update(messages.get(i));
            }
        }else{
            List<MessageAbstract> messages = query.list();
            for (int i=0; i<50; i++){
            /*if(i % this.batchSize == 0 && i > 0) {
                this.session.flush();
                this.session.clear();
            }*/
                messages.get(i).setText("update Text");
                this.session.update(messages.get(i));
            }
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long upddateSingle() {
        //Update User
        long startNanos = System.nanoTime();

        Query query = this.session.createQuery("from Message where id=49518");
        if(this.dbName==DBName.Oracle){
            Message message= (Message) query.getSingleResult();
            message.setText("updated Text");

            this.session.update(message);

        }else{

            MessageAbstract message = (MessageAbstract) query.getSingleResult();
            message.setText("updated Text");

            this.session.update(message);
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;

    }

    @Override
    public long deleteBulk() {

        long startNanos = System.nanoTime();

        Query query = this.session.createQuery("From Message ");

        if(this.dbName==DBName.Oracle){
            List<Message> messages = query.list();
            for (int i=0; i<50; i++){
            /*if(i % this.batchSize == 0 && i > 0) {
                this.session.flush();
                this.session.clear();
            }*/
                this.session.remove(messages.get(i));
            }

        }else{
            List<MessageAbstract> messages = query.list();
            for (int i=0; i<50; i++){
            /*if(i % this.batchSize == 0 && i > 0) {
                this.session.flush();
                this.session.clear();
            }*/
                this.session.remove(messages.get(i));
            }
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

    @Override
    public long deleteSingle() {
        // Delete a User
        long startNanos = System.nanoTime();

        Query query = this.session.createQuery("From Message ");
        if(this.dbName==DBName.Oracle){
            List<Message> messages = query.list();
            this.session.remove(messages.get(0));
        }else {
            List<MessageAbstract> messages = query.list();
            this.session.remove(messages.get(0));
        }

        long time =  TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
        return time;
    }

}
