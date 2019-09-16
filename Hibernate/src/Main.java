import com.company.Common.Display.DisplayArrayCatego;
import com.company.Common.Enums.DBName;
import org.hibernate.Session;
import Tests.*;

public class Main {
    public static void main(final String[] args) throws Exception {
        HibernateConnection hibernateConnection = new HibernateConnection(DBName.PostgreSQL);
        final Session session = hibernateConnection.getSession();

        session.clear();

        DisplayArrayCatego displayArrayCatego = new DisplayArrayCatego();

        long[] cudTest = new long[6];
        long[] fetchTest = new long[5];
        long[] functionTest = new long[3];


        try {
            session.beginTransaction();

            session.clear();

            /*HqlFetchTest hqlFetchTest = new HqlFetchTest(DBName.PostgreSQL, session);
            fetchTest[0]=hqlFetchTest.selectById();
            fetchTest[1]=hqlFetchTest.selectAll();
            fetchTest[2]=hqlFetchTest.selectWithConstraints();
            fetchTest[3]=hqlFetchTest.selectWithJoins();
            fetchTest[4]=hqlFetchTest.selectWithJoinsGroupBy();
            System.out.println("HQL Test");
            displayArrayCatego.fetchArray(fetchTest);

            session.clear();
            CriteriaFetchTest criteriaFetchTest = new CriteriaFetchTest(DBName.PostgreSQL, session);
            fetchTest[0]=criteriaFetchTest.selectById();
            fetchTest[1]=criteriaFetchTest.selectAll();
            fetchTest[2]=criteriaFetchTest.selectWithConstraints();
            fetchTest[3]=criteriaFetchTest.selectWithJoins();
            fetchTest[4]=criteriaFetchTest.selectWithJoinsGroupBy();
            System.out.println("Criteria Test");
            displayArrayCatego.fetchArray(fetchTest);*/

            session.clear();
            SqlFetchTest sqlFetchTest = new SqlFetchTest(DBName.PostgreSQL, session);
            fetchTest[0]=sqlFetchTest.selectById();
            fetchTest[1]=sqlFetchTest.selectAll();
            fetchTest[2]=sqlFetchTest.selectWithConstraints();
            fetchTest[3]=sqlFetchTest.selectWithJoins();
            fetchTest[4]=sqlFetchTest.selectWithJoinsGroupBy();
            System.out.println("SQL Test");
            displayArrayCatego.fetchArray(fetchTest);

            /*session.clear();
            HibernateStreamTest hibernateStreamTest = new HibernateStreamTest(DBName.PostgreSQL, session);
            fetchTest[0]=hibernateStreamTest.selectById();
            fetchTest[1]=hibernateStreamTest.selectAll();
            fetchTest[2]=hibernateStreamTest.selectWithConstraints();
            fetchTest[3]=hibernateStreamTest.selectWithJoins();
            fetchTest[4]=hibernateStreamTest.selectWithJoinsGroupBy();
            System.out.println("Stream Test");
            displayArrayCatego.fetchArray(fetchTest);

            session.clear();
            HibernateFunctionsTest hibernateFunctionsTest = new HibernateFunctionsTest(DBName.PostgreSQL, session);
            functionTest[0] = hibernateFunctionsTest.storedProceduresTest();
            functionTest[1] = hibernateFunctionsTest.inheritenceTest();
            functionTest[2] = hibernateFunctionsTest.associationTest();
            System.out.println("Function Test");
            displayArrayCatego.functionArray(functionTest);*/

        } finally {
            hibernateConnection.closeSession(session);
        }
    }
}