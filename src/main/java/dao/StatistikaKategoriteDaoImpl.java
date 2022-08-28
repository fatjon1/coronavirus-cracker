package dao;

import config.MySession;
import model.Qarku;
import model.StatistikaKategori;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class StatistikaKategoriteDaoImpl extends MySession implements Dao<StatistikaKategori, Long>{
    @Override
    public void persist(StatistikaKategori entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void saveAll(List<StatistikaKategori> entity) {

    }

    @Override
    public void update(StatistikaKategori entity) {
    getCurrentSession().update(entity);
    }

    @Override
    public StatistikaKategori findById(Long id) {
        return null;
    }


    public StatistikaKategori findByData(String id) {
        return findAll().stream().filter(statistikaKategori -> statistikaKategori.getDatat().equals(id)).findFirst().get();
    }

    @Override
    public void delete(StatistikaKategori entity) {

    }

    @Override
    public List<StatistikaKategori> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    public Boolean findByDate(Date date) {
        String hql = "FROM Qarku Q WHERE Q.datat = :date";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("date",date);
        return null;
    }
}
