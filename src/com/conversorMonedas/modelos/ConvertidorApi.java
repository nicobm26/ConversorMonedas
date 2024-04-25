package com.conversorMonedas.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertidorApi {
    public String apikey = "453a870bba07c3c1114b6a14";

    /*
    * Este metodo es para poder usar la url donde ya realiza la conversion especifica del dinero
    * */
    public ConversionRecord convertir(String base, String destino, float cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                +this.apikey+"/pair/"+base+"/"+destino+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString() );
            //System.out.println(response.body());
            return new Gson().fromJson(response.body(), ConversionRecord.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    /*
     * Este metodo es para poder usar la url donde solo calcula la tasa de conversion entre las monedas/divisas
     * */
    public static ConversionRecord tasaConversion(String base, String destino){
        HttpClient client = HttpClient.newHttpClient();
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                +"453a870bba07c3c1114b6a14"+"/pair/"+base+"/"+destino+"/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            return new Gson().fromJson(response.body(), ConversionRecord.class);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
