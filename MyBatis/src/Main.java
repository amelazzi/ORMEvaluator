
import Tests.MyBatisCUDTest;
import Tests.MyBatisFetchTest;
import Tests.MyBatisFunctionsTest;
import Tests.MyBatisStreamTest;
import com.company.Common.Display.DisplayArrayCatego;
import com.company.Common.Enums.DBName;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;


public class Main {
    public static void main(final String[] args) throws IOException, ParseException {
        MyBatisConnection myBatisConnection = new MyBatisConnection(DBName.MySQL);
        SqlSession session = myBatisConnection.getSession();

        DisplayArrayCatego displayArrayCatego = new DisplayArrayCatego();

        long[] cudTest = new long[6];
        long[] fetchTest = new long[5];
        long[] functionTest = new long[3];

        MyBatisCUDTest myBatisCUDTest = new MyBatisCUDTest(DBName.MySQL, session);
        session.clearCache();
        cudTest[0]=myBatisCUDTest.insertSingle();
        cudTest[1]=myBatisCUDTest.insertBulk();
        cudTest[2]=myBatisCUDTest.upddateSingle();
        cudTest[3]=myBatisCUDTest.updateBulk();
        cudTest[4]=myBatisCUDTest.deleteSingle();
        cudTest[5]=myBatisCUDTest.deleteBulk();
        System.out.println("Cud Test");
        displayArrayCatego.cudArray(cudTest);

        MyBatisFetchTest myBatisFetchTest = new MyBatisFetchTest(DBName.MySQL, session);
        session.clearCache();
        fetchTest[0]=myBatisFetchTest.selectById();
        fetchTest[1]=myBatisFetchTest.selectAll();
        fetchTest[2]=myBatisFetchTest.selectWithConstraints();
        fetchTest[3]=myBatisFetchTest.selectWithJoins();
        fetchTest[4]=myBatisFetchTest.selectWithJoinsGroupBy();
        System.out.println("Fetch Test");
        displayArrayCatego.fetchArray(fetchTest);

        MyBatisStreamTest myBatisStreamTest = new MyBatisStreamTest(DBName.MySQL, session);
        session.clearCache();
        fetchTest[0]=myBatisStreamTest.selectById();
        fetchTest[1]=myBatisStreamTest.selectAll();
        fetchTest[2]=myBatisStreamTest.selectWithConstraints();
        fetchTest[3]=myBatisStreamTest.selectWithJoins();
        fetchTest[4]=myBatisStreamTest.selectWithJoinsGroupBy();
        System.out.println("Stream Test");
        displayArrayCatego.fetchArray(fetchTest);


        MyBatisFunctionsTest myBatisFunctionsTest = new MyBatisFunctionsTest(DBName.MySQL, session);
        session.clearCache();
        functionTest[0] = myBatisFunctionsTest.storedProceduresTest();
        functionTest[1] = myBatisFunctionsTest.inheritenceTest();
        functionTest[2] = myBatisFunctionsTest.associationTest();
        System.out.println("Function Test");
        displayArrayCatego.functionArray(functionTest);


        myBatisConnection.closeSession(session);

    }
}
