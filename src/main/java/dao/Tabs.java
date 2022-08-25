package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Qarku;

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
public class Tabs {

    public String rasteGjithesej;
    public String rasteGjithesejDje;
    public String rasteAktive;
    public String rasteAktiveDje;
    public String teSheruar;
    public String teSheruarDje;
    public String teVdekur;
    public String teVdekurDje;
    public String testeGjithesej;
    public String testeGjithesejDje;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}