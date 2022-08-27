package service;

import config.DbInit;
import dao.StatistikaKategoriteDaoImpl;
import model.RasteAktive;
import model.StatistikaKategori;
import model.Stats;


public class StatistikaKategoriService {

    StatistikaKategoriteDaoImpl statistikaKategoriteDao = new StatistikaKategoriteDaoImpl();
    public boolean sinkronizo()  {

        try {
            Stats response = DbInit.getCategoryStatistics();

            // 1. Ciklo mbi response.categories
            // 2. Per secilen kategori do besh kete llogjike
                // a. kontrollo prezencen ne tabelen StatistikaKategori;
                // b. Nese eshte prezente, mos bej asgje, kalo tek elementi tjeter i ciklit
                // c. Nese nuk ekzisto, krijo nje objekt te ri te tipi StastikaKategori dhe id vendos daten

            for (int i = 0; i <= response.getKategorite().length; i ++) {
                String data = response.getKategorite()[i];
                StatistikaKategori model = new StatistikaKategori();
                model.setDatat(response.getKategorite()[i]);
                model.setRasteAktive(response.getRaste_aktive()[i]);
                model.setRasteTeReja(response.getRaste_te_reja()[i]);
                model.setRastetKumulative(response.getRaste_kumulative()[i]);
                model.setVdekjeKumulative(response.getVdekje_kumulative()[i]);
                model.setSheruar(response.getSheruar()[i]);
                this.statistikaKategoriteDao.persist(model);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void persist(StatistikaKategori entity) {
        statistikaKategoriteDao.openCurrentSessionwithTransaction();
        statistikaKategoriteDao.persist(entity);
        statistikaKategoriteDao.closeCurrentSessionwithTransaction();
    }
}
