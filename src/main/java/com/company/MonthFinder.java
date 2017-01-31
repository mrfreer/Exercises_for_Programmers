package com.company;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by dfreer on 1/25/2017.
 */
public class MonthFinder {
    Hashtable<Integer, String> months = new Hashtable<Integer, String>();

    public MonthFinder(){
        DateFormatSymbols dfs = new DateFormatSymbols();

        String [] m = dfs.getMonths();
        for(int i = 1; i <= 12; i++){
            months.put(i, m[i-1]);
        }
    }

    public void getNameMonth(int num){
        System.out.println("The name of the month is " + months.get(num));
    }

    public static int getUserInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the number of the month: ");
        while(!s.hasNextInt()) s.next();
        int num = s.nextInt();
        return num;
    }

    public static void main(String[] args) {
        new MonthFinder().getNameMonth(getUserInput());
    }


}
