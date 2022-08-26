package service;

import config.DbInit;
import dao.VdekjeKomulativeDaoImpl;
import model.Stats;
import model.VdekjeKomulative;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class VdekjeKomulativeService {

    VdekjeKomulativeDaoImpl vdekjeKomulativeDao = new VdekjeKomulativeDaoImpl();

    public void persist(VdekjeKomulative entity) {
        vdekjeKomulativeDao.openCurrentSessionwithTransaction();
        vdekjeKomulativeDao.persist(entity);
        vdekjeKomulativeDao.closeCurrentSessionwithTransaction();
    }

    public void init() throws URISyntaxException, IOException, InterruptedException {
        Stats stat = DbInit.getDatas();
        Map<Long, Integer> vdekjeKomutativeMap = new HashMap<>();

        for (Integer val :stat.getVdekje_kumulative()
        ) {
            Integer index = indexOf(stat.getVdekje_kumulative(), val);
            vdekjeKomutativeMap.put(Long.valueOf(index), val);
        }

        for (Map.Entry<Long, Integer> entry : vdekjeKomutativeMap.entrySet()) {
            this.persist(new VdekjeKomulative(entry.getKey(), entry.getValue()));
        }
    }
}
