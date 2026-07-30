package hibernateplayground.main;

import hibernateplayground.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("Application Started");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println("Application Ended");
    }
}