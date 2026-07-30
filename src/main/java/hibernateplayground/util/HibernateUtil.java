package hibernateplayground.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate2.cfg.xml")
                    .buildSessionFactory();

            System.out.println("✅ SessionFactory Created Successfully");

        } catch (Exception e) {
            System.out.println("❌ Error Creating SessionFactory");
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}