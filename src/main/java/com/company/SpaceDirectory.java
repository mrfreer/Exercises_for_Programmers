package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Astronaut {
        String craft;
        String name;

public String toString(){
        return name + " of " + craft;
        }
}

class AstronautData{
    List<Astronaut> astronauts;
    public List<Astronaut> getAstronauts(){
        return astronauts;
    }
    public String toString(){
        return "testing" + astronauts.size();
    }
}
/**
 * Created by David on 2/2/2017.
 */
public class SpaceDirectory {

    public static String readAll(Reader rd) throws IOException {

        BufferedReader reader = new BufferedReader(rd);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public void readIn() throws Exception{
      //http://api.open-notify.org/astros.json
        Gson gson = new Gson();


        URL url = new URL("http://api.open-notify.org/astros.json");
        InputStream is = url.openStream();

        InputStreamReader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String jsonText = readAll(bufferedReader);
        System.out.println(jsonText);
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(jsonText);
        JsonArray jsonArr = jo.getAsJsonArray("people");
        ArrayList jsonObjList = gson.fromJson(jsonArr, ArrayList.class);
        System.out.println("List size is : "+jsonObjList.size());
        System.out.println("List Elements are  : "+jsonObjList.toString());


        System.out.println("There are " + jsonObjList.size() + " in space right now:");
        System.out.println("--------------------------------------------");
        System.out.printf("%-30.30s  %-30.30s%n", "Craft",  "Name");
        for(Object o : jsonObjList){
            System.out.println(o);
        }

    }

    public static void main(String[] args) {
        try {
            new SpaceDirectory().readIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
