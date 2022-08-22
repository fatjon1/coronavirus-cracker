package dao;

import config.Hibernate;
import model.Qarku;
import org.hibernate.Session;

import java.util.List;

public class QarkuDao {

    public List<Qarku> getQarqet() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("from Qarku", Qarku.class).list();
        }
    }
}
