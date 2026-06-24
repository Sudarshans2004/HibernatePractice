package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {
    public static void main(String[] args) {


        // Step 1 - Build SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Step 2 - Create objects

        Emp e1 = new Emp();
        Emp e2 = new Emp();

        e1.setEid(34);
        e1.setEmpName("Sudarshan");

        e2.setEid(35);;
        e2.setEmpName("Shubham");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setPid(36);
        p1.setProjectName("Lib management System");

        p2.setPid(37);
        p2.setProjectName("Skin disease detection");

        List<Emp> l1 = new ArrayList<Emp>();
        List<Project> l2 = new ArrayList<Project>();
        l1.add(e1);
        l1.add(e2);

        l2.add(p1);
        l2.add(p2);

        e1.setProjects(l2);
        p2.setEmps(l1);
            // Step 3 - Open Session
    Session session = factory.openSession();

    // Step 4 - Begin Transaction
    Transaction tx = session.beginTransaction();

        // Step 5 - Save all objects
       session.persist(e1);
        session.persist(e2);
        session.persist(p1);
        session.persist(p2);

        // commit
        tx.commit();

        // Step 7 - Close
        session.close();
        factory.close();

    }
}
