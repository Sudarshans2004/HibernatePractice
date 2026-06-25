
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HqlDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // 1. Get ALL students
        Query<Student> query1 = session.createQuery("FROM Student", Student.class);
        List<Student> students = query1.list();

        for(Student s : students) {
            System.out.println(s.getId() + " : " + s.getName());
        }
//       2 Fetch only the names of all students.
        Query<String > query2 = session.createQuery("SELECT s.name FROM Student s", String.class);
        List <String> names = query2.list();
        names.forEach(System.out::println);

//       3 Fetch the student whose id = 5.
        Query<Student> query3 = session.createQuery(" FROM Student WHERE id =:id", Student.class);
        query3.setParameter("id",5);
        List <Student> namesWithS = query3.list();
        namesWithS.forEach(System.out::println);

        //update
        Query query4 = session.createQuery("UPDATE Student SET city= :city WHERE name = :name");
        query4.setParameter("city" , "mumbai ").setParameter("name","Sudarshan");
        int count = query4.executeUpdate();
        System.out.println("__________________________________");
        //delete
        Query query5 = session.createQuery("DELETE from Student WHERE name= :n");
        query5.setParameter("n","Shubh");
        int x = query5.executeUpdate();

        //join
        Query q1 = session.createQuery("SELECT q.question , q.questionId , a.answer FROM Question as q INNER JOIN q.answer as a");
        List <Object[]> list3=q1.getResultList();
        for(Object [] arr : list3){
            System.out.println(Arrays.toString(arr));
        }
        tx.commit();



        session.close();
        factory.close();
    }
}