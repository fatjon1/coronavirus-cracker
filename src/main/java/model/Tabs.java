package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Qarku;

import javax.persistence.Entity;
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

    public String raste_gjithesej;
    public String raste_gjithesej_dje;
    public String raste_aktive;
    public String raste_aktive_dje;
    public String te_sheruar;
    public String te_sheruar_dje;
    public String te_vdekur;
    public String te_vdekur_dje;
    public String teste_gjithesej;
    public String teste_gjithesej_dje;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}