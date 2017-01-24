package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by David on 1/24/2017.
 */
public class CurrencyConversion {


    public static void main(String[] args) {
        System.out.println("How many euros are you exchanging?");
        double qtyEuros;
        Scanner s = new Scanner(System.in);
        while(!s.hasNextDouble()) s.hasNext();
        qtyEuros = s.nextDouble();
        //1 euro equals 1.08 dollars

        System.out.println("What is the exchange rate?");
        while(!s.hasNextDouble()) s.hasNext();
        double exchange = s.nextDouble();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println(formatter.format(qtyEuros) + " euros at an exchange rate " +
                    " of " + exchange + " equals ");
        double amountTo = (qtyEuros * exchange);
        formatter = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println(formatter.format(amountTo));
    }
}
