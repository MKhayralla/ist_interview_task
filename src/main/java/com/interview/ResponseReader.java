package com.interview;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ResponseReader {
    public static JsonArray read_data(String res) {
        /**
         * Reads a string response and gets the data array from it
         * returns: JsonArray elements
         */
        // read json string
        JsonElement ele = JsonParser.parseString(res) ;
        // convert to object
        JsonObject usersArray = ele.getAsJsonObject() ;
        // get data array
        JsonElement data = usersArray.get("data") ;
        // convert to JsonArray
        JsonArray result = data.getAsJsonArray() ;
        // return result
        return result ;
    }
}
