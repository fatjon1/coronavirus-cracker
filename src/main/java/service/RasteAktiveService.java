package service;

import config.DbInit;
import dao.RasteAktiveDaoImpl;
import model.RasteAktive;
import model.Stats;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class RasteAktiveService {
    RasteAktiveDaoImpl rasteAktiveDao = new RasteAktiveDaoImpl();


    public RasteAktiveService(){}

    public void persist(RasteAktive entity) {
        rasteAktiveDao.openCurrentSessionwithTransaction();
        rasteAktiveDao.persist(entity);
        rasteAktiveDao.closeCurrentSessionwithTransaction();
    }

    public void init() throws URISyntaxException, IOException, InterruptedException {
        Stats stat = DbInit.getCategoryStatistics();
        Map<Long, Integer> rasteAktiveMap = new HashMap<>();

        for (Integer val :stat.getRaste_aktive()
        ) {
            Integer index = indexOf(stat.getRaste_aktive(), val);
            rasteAktiveMap.put(Long.valueOf(index), val);
        }

        for (Map.Entry<Long, Integer> entry : rasteAktiveMap.entrySet()) {
            this.persist(new RasteAktive(entry.getKey(), entry.getValue()));
        }
    }
}
