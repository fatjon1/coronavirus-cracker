package dao;

import config.Hibernate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Qarku;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
public class QarkuDaoImpl implements QarkuDao<Qarku, Long>{

    private Session currentSession = Hibernate.getSessionFactory().getCurrentSession();

    private Transaction currentTransaction;


    public Session openCurrentSession() {
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
       return Hibernate.getSessionFactory();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Qarku entity) {
        getCurrentSession().save(entity);
    }

    /*public void persistAll(List<Qarku> entity) {
        getCurrentSession().save(entity);
    }*/

    public void update(Qarku entity) {
        getCurrentSession().update(entity);
    }


    public Qarku findById(String ID) {
        Qarku book = (Qarku) getCurrentSession().get(Qarku.class, ID);
        return book;
    }

    public void delete(Qarku entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Qarku> findAll() {
        List<Qarku> books = (List<Qarku>) getCurrentSession().createQuery("from Book").list();
        return books;
    }

    public void deleteAll() {
        List<Qarku> entityList = findAll();
        for (Qarku entity : entityList) {
            delete(entity);
        }
    }
}