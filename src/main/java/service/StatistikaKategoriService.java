package service;

import config.DbInit;
import dao.StatistikaKategoriteDaoImpl;
import model.StatistikaKategori;
import model.Stats;

import java.text.SimpleDateFormat;
import java.util.Date;


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
                Date date=new SimpleDateFormat("yyyy-dd-MM").parse(response.getKategorite()[i]);
                model.setDatat(date);
                model.setRaste_aktive(response.getRaste_aktive()[i]);
                model.setRaste_te_reja(response.getRaste_te_reja()[i]);
                model.setRastet_kumulative(response.getRaste_kumulative()[i]);
                model.setVdekje_kumulative(response.getVdekje_kumulative()[i]);
                model.setSheruar(response.getSheruar()[i]);
                this.persist(model);
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
