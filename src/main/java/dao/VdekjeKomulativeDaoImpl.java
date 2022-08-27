package dao;

import config.Hibernate;
import config.MySession;
import model.VdekjeKomulative;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class VdekjeKomulativeDaoImpl extends MySession implements Dao<VdekjeKomulative, Long>{


    @Override
    public void persist(VdekjeKomulative entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<VdekjeKomulative> entity) {

    }

    @Override
    public void update(VdekjeKomulative entity) {

    }

    @Override
    public VdekjeKomulative findById(Long id) {
        return null;
    }

    @Override
    public void delete(VdekjeKomulative entity) {

    }

    @Override
    public List<VdekjeKomulative> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
