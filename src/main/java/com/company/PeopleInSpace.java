package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by dfreer on 2/2/2017.
 */
public class PeopleInSpace {
    ArrayList<String> peopleSpace = new ArrayList<>();
    public void getPeopleSpace() throws MalformedURLException{
        URL url = new URL("http://api.open-notify.org/astros.json");
        
    }
}
