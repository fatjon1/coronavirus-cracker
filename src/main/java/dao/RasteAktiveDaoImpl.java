package dao;

import config.Hibernate;
import config.MySession;
import model.RasteAktive;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class RasteAktiveDaoImpl extends MySession implements Dao<RasteAktive, Long>{

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
