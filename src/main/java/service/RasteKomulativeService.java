package service;

import config.DbInit;
import dao.RasteKomulativeDaoImpl;
import model.RasteKomulative;
import model.Stats;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class RasteKomulativeService {

    RasteKomulativeDaoImpl rasteKomulativeDao = new RasteKomulativeDaoImpl();

    public void persist(RasteKomulative entity) {
        rasteKomulativeDao.openCurrentSessionwithTransaction();
        rasteKomulativeDao.persist(entity);
        rasteKomulativeDao.closeCurrentSessionwithTransaction();
    }

    public void init() throws URISyntaxException, IOException, InterruptedException {
        Stats stat = DbInit.getCategoryStatistics();
        Map<Long, Integer> rasteKomutativeMap = new HashMap<>();

        for (Integer val :stat.getRaste_kumulative()
        ) {
            Integer index = indexOf(stat.getRaste_kumulative(), val);
            rasteKomutativeMap.put(Long.valueOf(index), val);
        }

        for (Map.Entry<Long, Integer> entry : rasteKomutativeMap.entrySet()) {
            this.persist(new RasteKomulative(entry.getKey(), entry.getValue()));
        }
    }
}
