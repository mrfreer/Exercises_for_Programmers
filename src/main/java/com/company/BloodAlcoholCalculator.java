package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by dfreer on 1/24/2017.
 */
public class BloodAlcoholCalculator {
    double alcoholConsumedOunces, bodyWeightPounds, hoursSinceLastDrink;
    String male_or_female;
    final double MALE_DISTRIBUTION_RATIO = .73;
    final double FEMALE_DISTRIBUTION_RATIO = .66;
    final double BAC = .08;
    public void getInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the ounces of alcohol consumed:");
        while(!s.hasNextDouble()) s.next();
        alcoholConsumedOunces = s.nextDouble();
        System.out.println("Enter your weight in pounds:");
        while(!s.hasNextDouble()) s.next();
        bodyWeightPounds = s.nextDouble();
        System.out.println("Enter 'M' if you are a male or 'F' if you are a female:");
        male_or_female = s.next();
        boolean canContinue = false;
        if(male_or_female.equalsIgnoreCase("M") || male_or_female.equalsIgnoreCase("F"))
        {
            canContinue = true;
        }
        else
        {
            while(canContinue == false){
                System.out.println("You must enter 'M' or 'F'");
                male_or_female = s.next();
            }
        }
        System.out.println("Enter the hours since your last drink:");
        while(!s.hasNextDouble()) s.next();
        hoursSinceLastDrink = s.nextDouble();
    }

    public boolean canDrive(){
        double userBAC;
        if(male_or_female.equalsIgnoreCase("M")){
            userBAC = (alcoholConsumedOunces * (5.14/bodyWeightPounds) * MALE_DISTRIBUTION_RATIO) -
                    (.15 * hoursSinceLastDrink);
        }
        else
        {
            userBAC = (alcoholConsumedOunces * (5.14/bodyWeightPounds) * FEMALE_DISTRIBUTION_RATIO) -
                    (.15 * hoursSinceLastDrink);
        }
        DecimalFormat df = new DecimalFormat(".##");
        System.out.println("Your BAC is " + df.format(userBAC) + "%");
        if(userBAC >= BAC)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        BloodAlcoholCalculator b = new BloodAlcoholCalculator();
        b.getInput();
        if(b.canDrive())
            System.out.println("It is legal for you to drive.");
        else
            System.out.println("It is NOT legal for you to drive.");
    }
}
