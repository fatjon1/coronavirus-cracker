
import config.CoronavirusLogo;
import config.DbInit;
import service.QarkuService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        DbInit.run();
        QarkuService qarkuService = new QarkuService();

        CoronavirusLogo.logoPrint();
        System.out.println(qarkuService.qarkuMeShumeInfektime());
        //System.out.println(qarkuService.findAll());



    }


}
