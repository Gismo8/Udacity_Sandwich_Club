package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwichJsonObject = new JSONObject(json);
        JSONObject name = sandwichJsonObject.getJSONObject("name");
        String mainName = name.getString("mainName");
        JSONArray alsoKnownAsJsonArray = name.getJSONArray("alsoKnownAs");

        ArrayList<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
            alsoKnownAs.add(alsoKnownAsJsonArray.getString(0));
        }

        String placeOfOrigin = sandwichJsonObject.getString("placeOfOrigin");
        String description = sandwichJsonObject.getString("description");
        String image = sandwichJsonObject.getString("image");
        JSONArray ingredientsJsonArray =  sandwichJsonObject.getJSONArray("ingredients");

        ArrayList<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsJsonArray.length(); i++) {
            ingredients.add(ingredientsJsonArray.getString(0));
        }

        Sandwich sandwich = null;
        sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        return sandwich;
    }
}
