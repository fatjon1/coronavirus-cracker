package dao;

import config.MySession;
import model.StatistikaKategori;

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
}
