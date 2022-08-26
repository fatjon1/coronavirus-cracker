package service;

import config.DbInit;
import dao.KategoriteDaoImpl;
import model.Kategorite;
import model.Sheruar;
import model.Stats;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class KategoriteService {

    KategoriteDaoImpl kategoriteDao = new KategoriteDaoImpl();

    public void persist(Kategorite entity) {
        kategoriteDao.openCurrentSessionwithTransaction();
        kategoriteDao.persist(entity);
        kategoriteDao.closeCurrentSessionwithTransaction();
    }

    public void init() throws URISyntaxException, IOException, InterruptedException {
        Stats stat = DbInit.getDatas();
        Map<Long, String> kategoriteMap = new HashMap<>();

        for (String kat:stat.getKategorite()
        ) {
            Integer index = indexOf(stat.getKategorite(), kat);
            kategoriteMap.put(Long.valueOf(index), kat);
        }

        for (Map.Entry<Long, String> entry : kategoriteMap.entrySet()) {
            //System.out.println(entry.getKey() + ":" + entry.getValue());
            this.persist(new Kategorite(entry.getKey(), entry.getValue()));
        }
    }
}
