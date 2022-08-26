package service;

import dao.StatsDaoImpl;
import lombok.RequiredArgsConstructor;
import model.Qarku;
import model.Stats;
@RequiredArgsConstructor
public class StatsService {

    StatsDaoImpl statsDao = new StatsDaoImpl();


    public void persist(Stats entity) {
        statsDao.openCurrentSessionwithTransaction();
        statsDao.persist(entity);
        statsDao.closeCurrentSessionwithTransaction();
    }

}