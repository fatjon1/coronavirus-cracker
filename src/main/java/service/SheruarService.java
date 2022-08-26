package service;

import config.DbInit;
import dao.SheruarDaoImpl;
import model.Kategorite;
import model.RasteAktive;
import model.Sheruar;
import model.Stats;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class SheruarService {

    SheruarDaoImpl sheruarDao = new SheruarDaoImpl();

    public void persist(Sheruar entity) {
        sheruarDao.openCurrentSessionwithTransaction();
        sheruarDao.persist(entity);
        sheruarDao.closeCurrentSessionwithTransaction();
    }
    public void init() throws URISyntaxException, IOException, InterruptedException {
        Stats stat = DbInit.getDatas();
        Map<Long, Integer> sheruarMap = new HashMap<>();

        for (Integer val :stat.getSheruar()
        ) {
            Integer index = indexOf(stat.getSheruar(), val);
            sheruarMap.put(Long.valueOf(index), val);
        }

        for (Map.Entry<Long, Integer> entry : sheruarMap.entrySet()) {
            this.persist(new Sheruar(entry.getKey(), entry.getValue()));
        }
    }
}
