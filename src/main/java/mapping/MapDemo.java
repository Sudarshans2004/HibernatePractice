package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Question q = new Question();
        q.setQuestionId(1212);
        q.setQuestion("What is Java");

        //Creating answer
        Answer ans = new Answer();
        ans.setAnswerId(343);
        ans.setAnswer("Java is programing language");
        ans.setQuestion(q);
        q.setAnswer(ans);

        Question q1= new Question();
        q1.setQuestionId(242);
        q1.setQuestion("What is Collection framework");

        //Creating answer
        Answer ans1 = new Answer();
        ans1.setAnswerId(344);
        ans1.setAnswer("API to work with java");
        ans.setQuestion(q1);
        q1.setAnswer(ans1);

        Session session = factory.openSession();

        // Step 4 - Begin Transaction
        Transaction tx = session.beginTransaction();

        // Step 5 - Save all objects
        session.persist(q1);
        session.persist(q);
        session.persist(ans);
        session.persist(ans1);
        // Step 6 - Commit
        tx.commit();

        // Step 7 - Close
        session.close();
        factory.close();
    }
}
