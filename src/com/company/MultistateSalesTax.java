package com.company;

import java.io.*;
import java.util.*;

/**
 * Created by dfreer on 1/25/2017.
 */
class State{
    String taxRegionName, state;
    double estimatedCombinedRate;
    Hashtable<Integer, Double> table = new Hashtable<Integer, Double>();
    //map the zip code to the tax rate

    public State(String state){
        this.state = state;
    }

    public void addTaxInfo(String fileName) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(".\\" + fileName);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            String[] allData = line.split(",");
            if (line != null) {
                int zip = Integer.parseInt(allData[1]);
                double rate = Double.parseDouble(allData[4]);
                table.put(zip, rate);
            }
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        br.close();
        fr.close();
    }


    public double findRateByZip(int zip){
        return (double)table.get(zip);
    }

    public void printTaxInfo(){
        Enumeration enumeration = table.elements();
        System.out.println(table.elements());
        while(enumeration.hasMoreElements())
        {
            System.out.println(" values " + enumeration.nextElement());
        }
    }
}

public class MultistateSalesTax {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        State fl = new State("FL");
        fl.addTaxInfo("Data\\TAXRATES_ZIP5_FL201701.csv");
        while(true){
            System.out.println("Enter a zip code to find the sales tax (FL only):");
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()) s.next();
            int zip = s.nextInt();
            System.out.println(fl.findRateByZip(zip));
        }
    }
}
