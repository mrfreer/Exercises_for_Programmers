package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by David on 1/29/2017.
 */
public class Statistics {
    private ArrayList<Double>allNumbers = new ArrayList<>();
    double average = 0.0;
    public void readIn(){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Enter a new number:");
            while(!s.hasNextDouble()) s.next();
            allNumbers.add(s.nextDouble());
            System.out.println("Enter done to quit.");
            if(s.next().equalsIgnoreCase("done"))
            {
                return;
            }
        }
    }
    public double computeAverage(){
        double sum = 0.0;
        for (double d: allNumbers) {
            sum += d;
        }
        average = sum / allNumbers.size();
        return average;
    }

    public double stdDev(){
        for(double d : allNumbers){
            System.out.println(d);
        }
        System.out.println(average + " is what.");
        double diffFromMean = 0.0;
        for(double d: allNumbers){
            diffFromMean += Math.pow(d - average, 2);
        }

        return Math.sqrt((diffFromMean)/(allNumbers.size()-1));
    }

    public double max(){
        double largest = allNumbers.get(0);
        for(int i = 1; i < allNumbers.size(); i++){
            if(allNumbers.get(i) > largest){
                largest = allNumbers.get(i);
            }

        }
        return largest;
    }

    public double min(){
        double smallest = allNumbers.get(0);
        for(int i = 1; i < allNumbers.size(); i++){
            if(allNumbers.get(i) < smallest){
                smallest = allNumbers.get(i);
            }

        }
        return smallest;
    }

    public static void main(String[] args) {
        Statistics s = new Statistics();
        s.readIn();
        System.out.println("Maximum " + s.max());
        System.out.println("Minimum " + s.min());
        System.out.println(s.computeAverage());
        System.out.println(s.stdDev());
    }

}


