package dao;

import config.Hibernate;
import config.MySession;
import model.Sheruar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SheruarDaoImpl extends MySession implements Dao<Sheruar, Long>{

      @Override
    public void persist(Sheruar entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<Sheruar> entity) {

    }

    @Override
    public void update(Sheruar entity) {

    }

    @Override
    public Sheruar findById(Long id) {
        return null;
    }

    @Override
    public void delete(Sheruar entity) {

    }

    @Override
    public List<Sheruar> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
