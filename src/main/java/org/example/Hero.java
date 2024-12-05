package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class Hero {
    String intelligence;
    String strength;
    String speed;
    String durability;
    String power;
    String combat;
    String name;
    Integer total_stats = 0;

    public Hero(String api_request){
        String json = new RestTemplate().getForObject(api_request, String.class);
        JsonObject response = JsonParser.parseString(json).getAsJsonObject();
        System.out.println(response);

        name = response.get("name").getAsString();
        intelligence = response.get("powerstats").getAsJsonObject().get("intelligence").getAsString();
        strength = response.get("powerstats").getAsJsonObject().get("strength").getAsString();
        speed = response.get("powerstats").getAsJsonObject().get("speed").getAsString();
        durability = response.get("powerstats").getAsJsonObject().get("durability").getAsString();
        power = response.get("powerstats").getAsJsonObject().get("power").getAsString();
        combat = response.get("powerstats").getAsJsonObject().get("combat").getAsString();
        ArrayList<String> stat_list = new ArrayList<String>(Arrays.asList(intelligence,strength,speed,durability,power,combat));


        for (String stat: stat_list){
            if (stat.equals("null")){
                continue;
            }
            total_stats += Integer.parseInt(stat);
        }
        System.out.println(total_stats);


    }

    public String fight(Hero otherhero){
        if(this.total_stats + otherhero.total_stats == 0){
            if(this.name.length() > otherhero.name.length()){
                return this.name + " wins!";
            } else {
                return otherhero.name + " wins!";
            }
        } else {
            if(this.total_stats > otherhero.total_stats){
                return this.name + " wins!";
            } else if (this.total_stats == otherhero.total_stats) {
                return "iz a tie!";
            } else {
                return otherhero.name + " wins!";
            }
        }
    }


    // standard constructor and setters/getters
}
