package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by David on 1/24/2017.
 */
public class TaxCalculator {
    final double WI_TAX = .055;
    double orderAmt, tax, total;
    String state = "";
    public void getInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is the order amount?");
        while(!s.hasNextDouble()) s.next();
        orderAmt = s.nextDouble();
        System.out.println("What is the state?");
        state = s.next();
        if(state.equalsIgnoreCase("WI"))
        {
            tax = (orderAmt * WI_TAX);
            total = tax + orderAmt;
        }
        else
        {
            tax = 0.0;
            total = orderAmt;
        }

    }
    public void displayOutput(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        if(state.equalsIgnoreCase("WI")){
            System.out.println("The subtotal is " +
                    nf.format(orderAmt));
            System.out.println("The tax is " + nf.format(tax));
            System.out.println("The total is " + nf.format(total) + ".");
        }
        else
        {
            System.out.println("The total is " + nf.format(total));
        }
    }

    public static void main(String[] args) {
        TaxCalculator t = new TaxCalculator();
        t.getInput();
        t.displayOutput();
    }
}
