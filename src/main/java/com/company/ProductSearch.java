
package com.company;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Wrapper;
import java.util.*;

class Product{
    public String name;
    public double price;
    public int quantity;

    public String toString(){
        return name + " Quantity: " + quantity + " Price $" + price;
    }
    }
/**
 * Created by dfreer on 2/1/2017.
 */
public class ProductSearch{

    public void readIn() throws IOException{
        String jsonString = new String(Files.readAllBytes(Paths.get("Data\\sample.json")),
                StandardCharsets.UTF_8);
        //System.out.println(jsonString);
        Gson gson = new Gson();
        Product[] data = gson.fromJson(jsonString, Product[].class);
        while(true){
            System.out.println("Enter a product to search for:");
            Scanner s = new Scanner(System.in);

            String userInput = s.next();
            boolean toFind = false;
            for(Product p : data){
                if(p.name.equals(userInput)){
                    System.out.println("Match -" +p.toString());
                    toFind = true;
                }
            }
            if(toFind == false){
                System.out.println("We're sorry.  We couldn't find that product.");
            }
            System.out.println("Enter quit to exit.");
            if(s.next().equalsIgnoreCase("quit"))
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        //reading in JSON files

        new ProductSearch().readIn();
    }
}
