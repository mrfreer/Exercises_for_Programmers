package com.company;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by David on 1/24/2017.
 */
public class SimpleInterest {
        double principal, interest, years;

        public void getInput(){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the principal:");
            while(!s.hasNextDouble()) s.next();
            principal = s.nextDouble();
            System.out.println("Enter the rate of interest:");
            while(!s.hasNextDouble()) s.next();
            interest = s.nextDouble();
            System.out.println("Enter the number of years:");
            while(!s.hasNextDouble()) s.next();
            years = s.nextDouble();
        }

        public void calcInterest(){
            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

            double amount = principal * (1 + (interest/100.0 * years));
            System.out.println("After " + years + " years " +
                    " at " + interest + "%, the investment " +
                    " will be worth " + formatter.format(amount));
        }

    public static void main(String[] args) {
        SimpleInterest s = new SimpleInterest();
        s.getInput();
        s.calcInterest();
    }
}
