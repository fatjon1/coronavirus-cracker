package config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Qarku;


import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetData {

//    kjo metode eshte per te mare te dhenat nga web servisi ne format json.
    public static Qarku[] getData() throws URISyntaxException, IOException, InterruptedException {
        List<Qarku> qarqet = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://coronavirus.al/api/qarqet.php"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());



        Gson gson = new GsonBuilder().create();
        Qarku[] qarqe = gson.fromJson(response.body(), Qarku[].class);
        /*for (Qarku qark : qarqe
                ) {
            System.out.println(qark);
        }*/
        return qarqe;

    }

}
