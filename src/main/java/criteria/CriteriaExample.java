package criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Studentt> cq = cb.createQuery(Studentt.class);
        Root<Studentt> root = cq.from(Studentt.class);
        cq.select(root);
        cq.select(root)
                .where(cb.equal(root.get("city"), "mumbai"));
        List<Studentt> students = session.createQuery(cq).getResultList();

//        for (Studentt s : students) {
//            System.out.println(s.getName()); // whatever fields Student has
//        }

        session.close();
    }
}