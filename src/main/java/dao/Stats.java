package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Stats {

    public Tabs tabs;
    public List<String> kategorite = null;
    public List<Integer> rasteAktive = null;
    public List<Integer> rasteTeReja = null;
    public List<Integer> rasteKumulative = null;
    public List<Integer> vdekjeKumulative = null;
    public List<Integer> sheruar = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static List<Stats> getData() throws URISyntaxException, IOException, InterruptedException {
        List<Stats> statsArrayList = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://coronavirus.al/api/stats.php"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());


        // bejme mapimin e te dhenave qe vijne nga metoda me siper
        // ne formatin json dhe i transformojme ne objekte java.
        Gson gson = new GsonBuilder().create();
        Stats[] stats = gson.fromJson(response.body(), Stats[].class); // i ruajme ne nje array
        //List<Stats> statsList = Arrays.stream(stats).toList(); //array e transformojme ne list
        //return statsList; // kthejme nje liste me te dhena
        return null;
    }

}
