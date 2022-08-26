import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.CoronavirusLogo;
import config.DbInit;
import model.Stats;
import service.QarkuService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        DbInit.run();
        QarkuService qarkuService = new QarkuService();
        Stats stats = new Stats();
        //System.out.println(qarkuService.findAll());
        // System.out.println(qarkuService.findByQarku("Berat"));
        CoronavirusLogo.logoPrint();
        //System.out.println(qarkuService.qarkuMeShumeInfektime());
        //System.out.println(qarkuService.findAll());

       //getDatas().forEach(stats1 -> System.out.println());
        //System.out.println(getDatas());
        //System.out.println(qarkuService.findQarkuByName("Fier"));

    }
    }
