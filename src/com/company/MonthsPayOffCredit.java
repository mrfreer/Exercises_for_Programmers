package com.company;

import java.util.Scanner;

/**
 * Created by David on 1/26/2017.
 */
public class MonthsPayOffCredit {
    int n;
    double i, b, p;
    public void readInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your balance?");
        while(!s.hasNextDouble()) s.next();
        b = s.nextDouble();
        System.out.println("What is the APR (as a percent)?");
        while(!s.hasNextDouble()) s.next();
        i = s.nextDouble();
        i /= 365.0;
        System.out.println("What is the monthly payment you can make?");
        while(!s.hasNextDouble()) s.next();
        p = s.nextDouble();
        n = (int)((-1.0/30.0) * (Math.log((1 + (b/p)*(1-(Math.pow((1+i),30))))/(Math.log(1+i)))));
        System.out.println(
                (-1/30.0)*Math.log(1)
        );
        System.out.println("It will take you " + n + " months to pay off the card.");
    }

    public static void main(String[] args) {
        //new MonthsPayOffCredit().readInput();
        double i = 12.0/365.0;
        System.out.println(
                (-1.0/30.0)* (Math.log(1 + (5000.0/100.0) * (1-(Math.pow((1+i), 30)))) / (Math.log(1+i)))
                //-1/30 x log(1+b/p(1-(1+i)^30)) / log(1+i)
        );
    }
}
