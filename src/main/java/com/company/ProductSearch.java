package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Person{
    private String NAME;
    private String P_LANGUAGE;
    private String LOCATION;
    public String toString(){
        return NAME + " " + LOCATION;
    }
    /*
    public Person(String NAME, String P_LANGUAGE, String LOCATION){
        this.NAME = NAME;
        this.LOCATION = LOCATION;
        this.P_LANGUAGE = P_LANGUAGE;
    }

    public Person(){

    }
    */
}
/**
 * Created by dfreer on 2/1/2017.
 */
public class ProductSearch{

    public void readIn() throws IOException{
        Gson gson = new Gson();
        JsonElement json = gson.fromJson(new FileReader("Data\\sample.json"), JsonElement.class);
        String result = gson.toJson(json);
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
//reading in JSON files
        new ProductSearch().readIn();
    }
}
