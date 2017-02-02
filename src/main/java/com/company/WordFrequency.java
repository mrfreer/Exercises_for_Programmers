package com.company;

import com.google.common.collect.Iterables;

import java.awt.geom.Arc2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by David on 2/1/2017.
 */
public class WordFrequency {
    Map<String, Long> counts;
    ArrayList<String> arrayList = new ArrayList<>();
    public void readIn(){

        try  {
            FileReader f = new FileReader("Data\\words.txt");
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                arrayList.add(s.next().replaceAll("[^a-zA-Z ]", "").toLowerCase());
            }

        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        counts = arrayList.stream().collect(Collectors.groupingBy(
                e->e, Collectors.counting()));


    }


    public void display(){

        Map<String, Long> finalMap = new LinkedHashMap<>();
        counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        for(Map.Entry<String, Long> entry: finalMap.entrySet()){
            String stars = "";
            for(int i = 0; i < entry.getValue(); i++){
                stars += "*";
            }
            System.out.printf("%-20.20s  %-20.10000s%n", entry.getKey(), stars);
            stars = "";

        }

/*
        for(int i = counts.size()-1; i >= 0; i--){
            String k = Iterables.get(counts.entrySet(),i).getKey();
            long l =  Iterables.get(counts.entrySet(),i).getValue();
            String stars = "";
            for(int j = 0; j < l; j++){
                stars += "*";
            }
            System.out.printf("%-30.30s  %-30.30s%n", k, stars);
            stars = "";
        }
        */
    }

    public static void main(String[] args) {
        WordFrequency wf = new WordFrequency();
        wf.readIn();
        wf.display();
    }

}
