package com.company;

import java.util.Scanner;

/**
 * Created by dfreer on 1/24/2017.
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("Press C to convert from Fahrenheit to Celsius.");
        System.out.println("Press F to convert from Celsius to Fahrenheit.");
        Scanner s = new Scanner(System.in);
        String userInput = s.next();
        if (userInput.equalsIgnoreCase("C")) {
            System.out.println("Please enter the temperature in Fahrenheit:");
            while (!s.hasNextDouble()) s.next(); //ensures only numbers are entered
            double temp = s.nextDouble();
            System.out.println("The temperature in Celsius is ");
            System.out.println((temp - 32) * (5.0/9.0));
        } else
        {
            System.out.println("Please enter the temperature in Celsius:");
            while(!s.hasNextDouble()) s.next();
            double temp = s.nextDouble();
            System.out.println("The temperature in Fahrenheit is ");
            System.out.println(temp * (9.0 / 5.0) + 32);
        }

    }
}
