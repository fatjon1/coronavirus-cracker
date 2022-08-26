package config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import model.Qarku;
import model.Stats;
import service.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;



public class DbInit {

    @SneakyThrows
    public static void run() {
        QarkuService qarkuService = new QarkuService();
        StatsService statsService = new StatsService();
        KategoriteService kategoriteService = new KategoriteService();
        RasteAktiveService rasteAktiveService = new RasteAktiveService();
        RasteKomulativeService rasteKomulativeService = new RasteKomulativeService();
        RasteTeRejaService rasteTeRejaService = new RasteTeRejaService();
        SheruarService sheruarService = new SheruarService();
        VdekjeKomulativeService vdekjeKomutativeService = new VdekjeKomulativeService();


            List<Qarku> qarqet = GetData.getData();
            qarkuService.saveAll(qarqet);
            kategoriteService.init();
            rasteAktiveService.init();
            rasteKomulativeService.init();
            rasteTeRejaService.init();
            sheruarService.init();
            vdekjeKomutativeService.init();


    }

    public static Stats getDatas() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://coronavirus.al/api/stats.php"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // bejme mapimin e te dhenave qe vijne nga metoda me siper
        // ne formatin json dhe i transformojme ne objekte java.
        Gson gson = new GsonBuilder().create();
        Stats stats = gson.fromJson(response.body(), Stats.class);
        return stats;
    }

}
