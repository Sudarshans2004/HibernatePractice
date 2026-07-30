package hibernateplayground.main;

import hibernateplayground.entity.Student;
import hibernateplayground.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DirtyCheckingDemo {

    public static void main(String[] args) {

        // Step 1: Open Session
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        // Step 2: Begin Transaction
        Transaction tx = session.beginTransaction();

        // Step 3: Fetch Student from Database
        Student student = session.find(Student.class, 1);

        // Step 4: Print Original Object
        System.out.println("Before Change : " + student);

        // Step 5: Modify Object
        student.setCity("pune");
        student.setAge(25);

        // Step 6: Print Modified Object
        System.out.println("After Change : " + student);

        // Step 7: Commit Transaction
        tx.commit();

        // Step 8: Close Session
        session.close();

        System.out.println("Session Closed Successfully");
    }
}