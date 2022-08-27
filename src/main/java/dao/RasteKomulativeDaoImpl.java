package dao;

import config.Hibernate;
import config.MySession;
import model.RasteKomulative;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RasteKomulativeDaoImpl extends MySession implements Dao<RasteKomulative, Long>{


    @Override
    public void persist(RasteKomulative entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<RasteKomulative> entity) {

    }

    @Override
    public void update(RasteKomulative entity) {

    }

    @Override
    public RasteKomulative findById(Long id) {
        return null;
    }

    @Override
    public void delete(RasteKomulative entity) {

    }

    @Override
    public List<RasteKomulative> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
