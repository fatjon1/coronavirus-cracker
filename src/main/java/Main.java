
import config.CoronavirusLogo;
import config.DbInit;
import model.Kategorite;
import model.Stats;
import service.KategoriteService;
import service.QarkuService;
import service.RasteAktiveService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static org.hibernate.internal.util.collections.ArrayHelper.indexOf;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        DbInit.run();
        QarkuService qarkuService = new QarkuService();

        CoronavirusLogo.logoPrint();
        System.out.println(qarkuService.qarkuMeShumeInfektime());
        //System.out.println(qarkuService.findAll());



    }


}
