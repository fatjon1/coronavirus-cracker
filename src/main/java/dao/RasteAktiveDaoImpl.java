package dao;

import config.Hibernate;
import model.RasteAktive;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RasteAktiveDaoImpl implements Dao<RasteAktive, Long>{

    private Session currentSession;

    private Transaction currentTransaction;

    public RasteAktiveDaoImpl() {
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
    public void persist(RasteAktive entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<RasteAktive> entity) {

    }

    @Override
    public void update(RasteAktive entity) {

    }

    @Override
    public RasteAktive findById(Long id) {
        return null;
    }

    @Override
    public void delete(RasteAktive entity) {

    }

    @Override
    public List<RasteAktive> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
