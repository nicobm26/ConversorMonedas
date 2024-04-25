package com.conversorMonedas.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertidorApi {
    public String apikey = "453a870bba07c3c1114b6a14";
    public void convertir(String base, String destino, int cantidad){
        HttpClient client = HttpClient.newHttpClient();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                +this.apikey+"/pair/"+base+"/"+destino+"/"+cantidad);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
