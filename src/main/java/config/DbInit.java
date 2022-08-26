package config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import model.Qarku;
import model.Stats;
import service.QarkuService;
import service.StatsService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class DbInit {

    @SneakyThrows
    public static void run() {
        QarkuService qarkuService = new QarkuService();
        StatsService statsService = new StatsService();


            List<Qarku> qarqet = GetData.getData();
            qarkuService.saveAll(qarqet);
            statsService.persist(getDatas());

    }

    public static Stats getDatas() throws URISyntaxException, IOException, InterruptedException {
        List<Stats> statsArrayList = new ArrayList<>();
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
        String kat = Arrays.stream(stats.kategorite).findFirst().get();
        String[] myArray = new String[1];
        myArray[0] = "kat";
        Stats st = new Stats();
        st.setKategorite(myArray);
        return st;
    }

}
