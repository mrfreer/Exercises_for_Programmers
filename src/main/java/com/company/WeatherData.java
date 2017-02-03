package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dfreer on 2/3/2017.
 */
class Weather{
    double temp, pressure, humidity, temp_min, temp_max;
    public String toString(){
        if(temp > 90)
            return "It's hot out!" + temp + "  Pressure " + pressure + " Humidity " + humidity;
        else if(temp > 60)
            return "It's nice out! " + temp + "  Pressure " + pressure + " Humidity " + humidity;
        else if(temp > 40)
            return "It's cool out! " + temp + "  Pressure " + pressure + " Humidity " + humidity;
        else
            return "It's cold out! " + temp + "  Pressure " + pressure + " Humidity " + humidity;
    }
}
public class WeatherData {
    public static String API;

    public static void readAPI() throws FileNotFoundException {
        FileReader fr = new FileReader("C:\\Users\\dfreer\\Documents\\Programming\\API.txt");
        Scanner s = new Scanner(fr);
        API = s.next();
    }


    public static void main(String[] args) throws Exception {
        WeatherData w = new WeatherData();
        readAPI();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Enter the city you wish to search for. Quit to exit.");
            String city = s.nextLine();
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city +
                    "&appid=" + API + "&units=Imperial");
            InputStream is = url.openStream();
            InputStreamReader ir = new InputStreamReader(is, "UTF-8");
            SpaceDirectory sd = new SpaceDirectory();
            String jsonText = SpaceDirectory.readAll(ir);
            Gson gson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonText);
            JsonObject jsonWeather = jo.getAsJsonObject("main");
            Weather curWeather = gson.fromJson(jsonWeather, Weather.class);
            System.out.println(curWeather.toString());
            if(city.equalsIgnoreCase("quit"))
                break;
        }
    }
}