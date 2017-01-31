package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by dfreer on 1/25/2017.
 */
public class BMI_Calculator {
    double heightInches, weightPounds;
    public BMI_Calculator(double heightInches, double weightPounds){
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
    }

    public void findRange(){
        DecimalFormat df = new DecimalFormat(".#");
        double bmi = (weightPounds/(heightInches * heightInches)) * 703;
        System.out.println("Your BMI is " + df.format(bmi));
        if(bmi >= 18.5 && bmi <= 25) {
            System.out.println("You are within the ideal weight range.");
        }
        else if(bmi > 25)
            System.out.println("You are overweight.  You should see your doctor.");
        else
            System.out.println("You are underweight.  You should see your doctor.");

    }

    public static void main(String[] args) {
        System.out.println("Enter your height in inches:");
        Scanner s = new Scanner(System.in);
        while(!s.hasNextDouble()) s.next();
        double h = s.nextDouble();
        System.out.println("Enter your weight in pounds:");
        while(!s.hasNextDouble()) s.next();
        double w = s.nextDouble();
        BMI_Calculator b = new BMI_Calculator(h, w);
        b.findRange();
    }
}
