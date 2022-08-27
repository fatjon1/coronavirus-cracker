package dao;

import config.Hibernate;
import config.MySession;
import model.RasteTeReja;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RasteTeRejaDaoImpl extends MySession implements Dao<RasteTeReja, Long>{

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
