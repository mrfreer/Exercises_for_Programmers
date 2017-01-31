package com.company;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by dfreer on 1/23/2017.
 */
public class SelfCheckout {
    double taxes = 0, subtotal = 0, total = 0, price = 0;
    final double TAX_RATE = .055;
    int quantity, itemNo = 1;

    public boolean readIn(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the price of item " + itemNo + ":");
        while (!s.hasNextDouble()) s.next();
        price = s.nextDouble();
        System.out.println("Enter the quantity of item " + itemNo + ":");
        while (!s.hasNextInt()) s.next();

        quantity = s.nextInt();
   //     System.out.println(price + " " + quantity);
        calcTotals();
        System.out.println("Enter 'q' to quit.");
        if(s.next().equalsIgnoreCase("q"))
            return false;
        else
            return true;

    }

    public void calcTotals(){
        subtotal += (price * quantity);
        taxes += (subtotal * TAX_RATE);
        total += (subtotal + taxes);
    //    System.out.println(total);
    }

    public static void main(String[] args) {
        boolean toCont = true;
        SelfCheckout s = new SelfCheckout();
        while(toCont){
            toCont = s.readIn();
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Subtotal " + formatter.format(s.subtotal));
        System.out.println("Taxes " + formatter.format(s.taxes));
        System.out.println("Total " + formatter.format(s.total));
    }
}
