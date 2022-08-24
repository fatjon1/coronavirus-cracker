import config.DbInit;
import config.GetData;
import model.Qarku;
import service.QarkuService;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        DbInit.run(); // ne momentin qe startohet app behet reset database dhe ruahen te dhenat e perditesuara.

        QarkuService qarkuService = new QarkuService();

        //System.out.println(qarkuService.findAll());
       // System.out.println(qarkuService.findByQarku("Berat"));
        System.out.println(qarkuService.qarkuMeShumeInfektime());


    }
}

