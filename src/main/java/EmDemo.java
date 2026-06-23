import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {

        // Step 1 - Build SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Step 2 - Create objects
        Student s1 = new Student();
        s1.setName("Sud");

        Student s2 = new Student();
        s2.setName("Shubh");

        Certificate cf = new Certificate();
        cf.setCourse("Java");
        cf.setDuration("6 Months");
        s1.setCerti(cf);   // link certificate to student

        Certificate cf2 = new Certificate();
        cf2.setCourse("Spring");
        cf2.setDuration("1 year");
        s2.setCerti(cf2);  // link certificate to student

        // Step 3 - Open Session
        Session session = factory.openSession();

        // Step 4 - Begin Transaction
        Transaction tx = session.beginTransaction();

        // Step 5 - Save all objects
        session.persist(s1);
        session.persist(s2);


        // Step 6 - Commit
        tx.commit();

        // Step 7 - Close
        session.close();
        factory.close();

        System.out.println("Done!");
    }
}