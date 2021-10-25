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
        }
}