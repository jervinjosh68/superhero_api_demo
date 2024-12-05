package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
//        String json = new RestTemplate().getForObject("https://official-joke-api.appspot.com/jokes/random", String.class);
//        JsonObject response = JsonParser.parseString(json).getAsJsonObject();
//        String a = response.get("setup").getAsString();
//        String b = response.get("punchline").getAsString();
//        System.out.println(a + ", " + b);
//        String newjson = new RestTemplate().getForObject("https://official-joke-api.appspot.com/jokes/ten", String.class);
//        JsonArray newresponse = JsonParser.parseString(newjson).getAsJsonArray();
//        System.out.println(newresponse.get(5));
        String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
        String ryan_hero_id = "12";
        String gabe_hero_id = "302";
        String api_request = "https://superheroapi.com/api/"+ACCESS_TOKEN+"/";
        Hero ryan_hero = new Hero(api_request+ryan_hero_id);
        Hero gabe_hero = new Hero(api_request+gabe_hero_id);
        System.out.println(ryan_hero.fight(gabe_hero));

    }
}
