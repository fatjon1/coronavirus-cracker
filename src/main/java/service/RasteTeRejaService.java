package service;

import config.DbInit;
import dao.RasteTeRejaDaoImpl;
import model.Kategorite;
import model.RasteAktive;
import model.RasteTeReja;
import model.Stats;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class RasteTeRejaService {

    RasteTeRejaDaoImpl rasteTeRejaDao = new RasteTeRejaDaoImpl();

    public void persist(RasteTeReja entity) {
        rasteTeRejaDao.openCurrentSessionwithTransaction();
        rasteTeRejaDao.persist(entity);
        rasteTeRejaDao.closeCurrentSessionwithTransaction();
    }

    public void init() throws URISyntaxException, IOException, InterruptedException {
        Stats stat = DbInit.getDatas();
        Map<Long, Integer> rasteTeRejaMap = new HashMap<>();

        for (Integer val :stat.getRaste_te_reja()
        ) {
            Integer index = indexOf(stat.getRaste_te_reja(), val);
            rasteTeRejaMap.put(Long.valueOf(index), val);
        }

        for (Map.Entry<Long, Integer> entry : rasteTeRejaMap.entrySet()) {
            this.persist(new RasteTeReja(entry.getKey(), entry.getValue()));
        }
    }
}
