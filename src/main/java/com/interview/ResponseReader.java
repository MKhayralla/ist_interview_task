package com.interview;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ResponseReader {
    public static JsonArray read_data(String res) {
        JsonElement ele = JsonParser.parseString(res) ;
        JsonObject usersArray = ele.getAsJsonObject() ;
        JsonElement data = usersArray.get("data") ;
        JsonArray result = data.getAsJsonArray() ;
        return result ;
    }
}
