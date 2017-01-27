package com.company;

import java.util.Scanner;

/**
 * Created by David on 1/26/2017.
 */
public class MonthsPayOffCredit {
    int n;
    double i, b, p, calculation;
    public void readInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your balance?");
        while(!s.hasNextDouble()) s.next();
        b = s.nextDouble();
        System.out.println("What is the APR (as a decimal)?");
        while(!s.hasNextDouble()) s.next();
        i = s.nextDouble();
        i /= 365.0;
        System.out.println("What is the monthly payment you can make?");
        while(!s.hasNextDouble()) s.next();
        p = s.nextDouble();


        calculation = (Math.log((1 + (double)(b / p) * (1 - (Math.pow(1 + (i), 30)))))) / (Math.log((1 + (i))));
        double months = (-0.033333333333333333) * calculation;
        int n = (int)Math.ceil(months);
        System.out.println(n + " months to pay it off.");
    }

    public static void main(String[] args) {
        new MonthsPayOffCredit().readInput();

    }
}
