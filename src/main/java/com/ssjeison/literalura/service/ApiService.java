package com.ssjeison.literalura.service;
import java.net.http.*;
import java.net.URI;

import static java.net.http.HttpClient.newHttpClient;

public class ApiService {
    private static final String API_URL = "https://gutendex.com/books/";

    public String fetchBooks(String query) throws Exception {
        HttpClient client = newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "?search=" + query))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
