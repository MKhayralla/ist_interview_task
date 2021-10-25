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
        /**
         * schedule an API call then print emails after deserializing json response
         */
        // create an Http client
        HttpClient client = HttpClient.newHttpClient();
        // build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users?page=2"))
                .build();
        HttpResponse<String> response;
        try {
            // read response
            response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
                ) ;
            // read dat array using ResponseReader class
            JsonArray res = ResponseReader.read_data(response.body()) ;
            // an iterator for iterating the array
            Iterator<JsonElement> ite = res.iterator() ;
            while (ite.hasNext()) {
                // convert to json object
                JsonObject obj = ite.next().getAsJsonObject() ;
                // print email of the user
                System.out.println(obj.get("email")) ;
            }
        } catch (IOException | InterruptedException e) {
            // print error stack trace 
            e.printStackTrace();
        }       
    }
}