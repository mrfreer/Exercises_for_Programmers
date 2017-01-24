package com.company;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by David on 1/24/2017.
 */
public class CompoundInterest {

    double principal, annualInterest, numYears, timesCompounded
            , amountEnd;

    public void getInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is the principal amount?");
        while(!s.hasNextDouble()) s.next();
        principal = s.nextDouble();
        System.out.println("What is the rate?");
        while(!s.hasNextDouble()) s.next();
        annualInterest = s.nextDouble();
        System.out.println("What is the number of years?");
        while(!s.hasNextDouble()) s.next();
        numYears = s.nextDouble();
        System.out.println("What is the number of times" +
        " the interest is compounded per year?");
        while(!s.hasNextDouble()) s.next();
        timesCompounded = s.nextDouble();
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        amountEnd = principal * Math.pow(1 + ((annualInterest/100) / timesCompounded), (timesCompounded * numYears));
        System.out.println("$" + principal + " invested " +
        "at " + annualInterest + "% for " + numYears +
        " compounded " + timesCompounded + " times per year is " +
        nf.format(amountEnd));
    }

    public static void main(String[] args) {
        new CompoundInterest().getInput();
    }
}
