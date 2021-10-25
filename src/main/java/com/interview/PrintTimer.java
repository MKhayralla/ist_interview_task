package com.interview;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.TimerTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

class PrintTimer extends TimerTask {
    @Override
    public void run() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users?page=2"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
                ) ;
            JsonArray res = ResponseReader.read_data(response.body()) ;
            Iterator<JsonElement> ite = res.iterator() ;
            while (ite.hasNext()) {
                JsonObject obj = ite.next().getAsJsonObject() ;
                System.out.println(obj.get("email")) ;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }       
    }
}