import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        // Step 1 - Build SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Step 2 - Get Session
        Session session = factory.openSession();

        // Step 3 - Begin Transaction
        Transaction tx = session.beginTransaction();

        // Step 4 - Create Student object
        Student s = new Student();
        s.setName("Sudarshan");
//        s.setId(101);

//        Student ss = session.get(Student.class,1);
//        System.out.println("Found: " + ss.getName());
//        Student s2 = session.load(Student.class,1);
//        System.out.println("Found: " + s2.getName());

        //address class
        Address ad = new Address();
        ad.setStreet("vishal nagar");
        ad.setCity("Nanded");
        ad.setOpen(true);
        ad.setX(1221.132);
        ad.setAddDate(new Date());
        FileInputStream fis = new FileInputStream("src/main/resources/wallpapper.jpg");
        byte[] d =new byte[fis.available()];
        fis.read(d);
        ad.setImage(d);
        // Step 5 - Save
        session.persist(s);
        session.persist(ad);
        // Step 6 - Commit
        tx.commit();

        System.out.println("Student saved successfully!");

        // Step 7 - Close
        session.close();
        factory.close();
        System.out.println("done");
    }
}