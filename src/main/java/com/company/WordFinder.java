package com.company;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by dfreer on 2/1/2017.
 */
public class WordFinder {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.out.println("Replacing utilize with use.");
        readIn();
    }
    public static void readIn()throws FileNotFoundException, IOException{
        FileReader f = new FileReader("Data\\Wordsearch.txt");
        Scanner s = new Scanner(f);
        String entire = "";
        int changes = 0;
        while(s.hasNext()){
            String current = s.next();
            if(current.contains("utilize"))
            {
                changes++;
                entire += "use ";
            }
            else
            {
                entire += current + " ";
            }
        }
        FileWriter fw = new FileWriter("Data\\WordsearchFixed.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.print(entire);
        pw.close();
        JOptionPane.showMessageDialog(null, "Number of times removed utilize: " +changes);
    }
}
