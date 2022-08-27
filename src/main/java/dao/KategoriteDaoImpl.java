package dao;

import config.Hibernate;
import config.MySession;
import model.Kategorite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class KategoriteDaoImpl extends MySession implements Dao<Kategorite, Long>{


    public void persist(Kategorite entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<Kategorite> entity) {

    }

    @Override
    public void update(Kategorite entity) {

    }

    @Override
    public Kategorite findById(Long id) {
        return null;
    }

    @Override
    public void delete(Kategorite entity) {

    }

    @Override
    public List<Kategorite> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
