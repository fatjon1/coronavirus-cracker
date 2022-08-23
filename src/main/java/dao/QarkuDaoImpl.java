package dao;

import config.Hibernate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Qarku;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class QarkuDaoImpl implements QarkuDao<Qarku, Long>{

    private Session currentSession;

    private Transaction currentTransaction;

    public QarkuDaoImpl() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
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

    @Override
    public void saveAll(List<Qarku> entity) {
        entity.forEach(e->getCurrentSession().save(e));
    }

    /*public void persistAll(List<Qarku> entity) {c
        getCurrentSession().save(entity);
    }*/

    public void update(Qarku entity) {
        getCurrentSession().update(entity);
    }


    public Qarku findById(Long id) {
        Qarku qarku = (Qarku) getCurrentSession().get(Qarku.class, id);
        return qarku;
    }

    public void delete(Qarku entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Qarku> findAll() {
        List<Qarku> books = (List<Qarku>) getCurrentSession().createQuery("from Qarku").list();
        return books;
    }

    public void deleteAll() {
        List<Qarku> entityList = findAll();
        for (Qarku entity : entityList) {
            delete(entity);
        }
    }
}