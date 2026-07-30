package hibernateplayground.main;

import hibernateplayground.entity.Student;
import hibernateplayground.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FlushDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setName("Amit");
        student.setCity("Delhi");
        student.setAge(24);

        session.persist(student);

        System.out.println("After persist()");

        session.flush();

        System.out.println("After flush()");

        tx.commit();

        System.out.println("After commit()");

        session.close();
    }
}