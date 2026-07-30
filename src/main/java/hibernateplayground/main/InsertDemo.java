package hibernateplayground.main;

import hibernateplayground.entity.Student;
import hibernateplayground.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setAge(22);
        student.setCity("Nanded");
        student.setName("Sudarshan");
        System.out.println("Before persist" +student);
        session.persist(student);
        System.out.println("After Persist"+ student);

        transaction.commit();
        session.close();
    }
}
