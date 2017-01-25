package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by dfreer on 1/25/2017.
 */
class State{
    String taxRegionName, state;
    double estimatedCombinedRate;
    Hashtable map = new Hashtable<Integer, Double>();
    //map the zip code to the tax rate

    public State(String state){
        this.state = state;
    }

    public void addTaxInfo(Hashtable<Integer, Double> hm){
        map = hm;
    }

    public double findRateByZip(int zip){
        return (double)map.get(zip);
    }

}

public class MultistateSalesTax {

    HashSet<State> allStates = new HashSet<>();

    public HashSet<State> getAllStates(){
        return allStates;
    }

    public State makeState(){
        try {
            FileReader f = new FileReader(".\\Data\\TAXRATES_ZIP5_FL201701.csv");
            Scanner s = new Scanner(f);
            s.nextLine();
            String withState = s.nextLine();
            String [] allData = withState.split(",");
            allStates.add(new State(allData[0]));
            return new State(allData[0]);
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
    return null;
    }

    public void addZipTaxInfo(State s) throws FileNotFoundException{
        FileReader fr = new FileReader(".\\Data\\TAXRATES_ZIP5_FL201701.csv");
        BufferedReader br = new BufferedReader(fr);
        Hashtable table = new Hashtable<Integer, Double>();

        try  {
            br.readLine();
            String line =  br.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null){
                String [] allData = line.split(",");
                if(line != null){
                    int zip = Integer.parseInt(allData[1]);
                    double rate = Double.parseDouble(allData[4]);
                    table.put(zip, rate);
                }

                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                //System.out.println(line);
            }
            s.addTaxInfo(table);
            allStates.add(s);
        br.close();
            fr.close();

        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException io){
            io.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        MultistateSalesTax ms = new MultistateSalesTax();
        ms.addZipTaxInfo(ms.makeState());
        while(true){
            System.out.println("Enter a zip code to find the sales tax (FL only):");
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()) s.next();
            int zip = s.nextInt();
            Set<State> allStates = ms.getAllStates();
            for(State curState : allStates){
                if(curState.state.equals("FL"))
                    System.out.println(curState.map.get(zip));
            }
        }
    }
}
