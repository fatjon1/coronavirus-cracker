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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DbInit {

    @SneakyThrows
    public static void run() {
        QarkuService qarkuService = new QarkuService();
        StatsService statsService = new StatsService();
        StatistikaKategoriService statistikaKategoriService = new StatistikaKategoriService();


            List<Qarku> qarqet = getQarqetData();
            qarkuService.saveAll(qarqet);
            statistikaKategoriService.sinkronizo();


    }

    public static Stats getCategoryStatistics() throws URISyntaxException, IOException, InterruptedException {
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


    //kjo metode eshte per te mare te dhenat nga web servisi ne format json.
    public static List<Qarku> getQarqetData() throws URISyntaxException, IOException, InterruptedException {
        List<Qarku> qarqet = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://coronavirus.al/api/qarqet.php"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());


        // bejme mapimin e te dhenave qe vijne nga metoda me siper
        // ne formatin json dhe i transformojme ne objekte java.
        Gson gson = new GsonBuilder().create();
        Qarku[] qarqe = gson.fromJson(response.body(), Qarku[].class); // i ruajme ne nje array
        List<Qarku> qarqeList = Arrays.stream(qarqe).toList(); //array e transformojme ne list
        return qarqeList; // kthejme nje liste me te dhena

    }

}
