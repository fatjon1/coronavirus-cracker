package dao;

import config.Hibernate;
import config.MySession;
import model.Stats;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StatsDaoImpl extends MySession implements Dao<Stats,Long>{



    @Override
    public void persist(Stats entity) {
        getCurrentSession().save(entity);

    }

    @Override
    public void saveAll(List<Stats> entity) {

    }

    @Override
    public void update(Stats entity) {

    }

    @Override
    public Stats findById(Long id) {
        return null;
    }

    @Override
    public void delete(Stats entity) {

    }

    @Override
    public List<Stats> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
