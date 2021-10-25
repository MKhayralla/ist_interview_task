package com.interview;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.TimerTask;

class PrintTimer extends TimerTask {
    @Override
    public void run() {
        System.out.println("Mahmoud");
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
            System.out.println(response.body()) ;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }       
    }
}