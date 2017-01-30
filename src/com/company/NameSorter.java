package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by dfreer on 1/30/2017.
 */
public class NameSorter {
ArrayList<String> allNames = new ArrayList<>();

public void readInNames(){
    try  {
        FileReader f = new FileReader("Data\\Names.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            allNames.add(s.nextLine());
        }
    }catch (FileNotFoundException f){
        f.printStackTrace();
    }
}

public void writeNames() throws IOException{
    FileWriter f = new FileWriter("Data\\NamesSorted.txt", true);
    PrintWriter p = new PrintWriter(f);
    p.append("Total of " + allNames.size() + " names" + "\n");
    Collections.sort(allNames);
    p.append("---------------------" + "\n");
    for(String name : allNames){
        p.append(name + "\n");
    }
    p.close();
}

    public static void main(String[] args) throws IOException {
        NameSorter n = new NameSorter();
        n.readInNames();
        n.writeNames();
    }
}
