package mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

//        Question q = new Question();
//        q.setQuestionId(1212);
//        q.setQuestion("What is Java");
//
//        //Creating answer
//        Answer ans = new Answer();
//        ans.setAnswerId(343);
//        ans.setAnswer("Java is programing language");
//        ans.setQuestion(q);
//
//        Answer ans1 = new Answer();
//        ans1.setAnswerId(33);
//        ans1.setAnswer("Java is high level language");
//        ans1.setQuestion(q);
//
//        Answer ans2 = new Answer();
//        ans2.setAnswerId(363);
//        ans2.setAnswer("java has diff types of framework");
//        ans2.setQuestion(q);
//
//        List <Answer> list = new ArrayList<>();
//        list.add(ans);
//        list.add(ans1);
//        list.add(ans2);
//
//        q.setAnswers(list);
//
        Session session = factory.openSession();
//
//        // Step 4 - Begin Transaction
        Transaction tx = session.beginTransaction();
//
//        // Step 5 - Save all objects
//        session.persist(q);
//        session.persist(ans);
//        session.persist(ans1);
//        session.persist(ans2);
        Question q = (Question) session.get(Question.class,1212);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        //lazy = Lazy Loading means related objects are fetched from the database only when they are actually needed.
//        System.out.println(q.getAnswers().size());



        // Step 6 - Commit
        tx.commit();

        // Step 7 - Close
        session.close();
        factory.close();
    }
}
