package com.ssjeison.literalura.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssjeison.literalura.model.Book;

public class JsonParser {
    private final Gson gson = new Gson();

    public Book[] parseBooks(String jsonResponse) {
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        return gson.fromJson(jsonObject.get("results"), Book[].class);
    }
}
