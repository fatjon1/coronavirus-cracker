package dao;

import config.Hibernate;
import model.RasteTeReja;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RasteTeRejaDaoImpl implements Dao<RasteTeReja, Long>{

    private Session currentSession;

    private Transaction currentTransaction;

    public RasteTeRejaDaoImpl() {
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
    @Override
    public void persist(RasteTeReja entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<RasteTeReja> entity) {

    }

    @Override
    public void update(RasteTeReja entity) {

    }

    @Override
    public RasteTeReja findById(Long id) {
        return null;
    }

    @Override
    public void delete(RasteTeReja entity) {

    }

    @Override
    public List<RasteTeReja> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
