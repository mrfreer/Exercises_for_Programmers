package com.company;

import java.util.Scanner;

/**
 * Created by David on 1/27/2017.
 */
public class KarvonenHeartRate {

    int restingPulse, age;
    public KarvonenHeartRate(int rp, int age){
        restingPulse = rp;
        this.age = age;
    }

    public int calculate(int intensity){
        return (int)(((220-age)-restingPulse) * intensity/100.0) + restingPulse;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your resting pulse:");
        while(!s.hasNextInt()) s.next();
        int rp = s.nextInt();
        System.out.println("Enter your age:");
        while(!s.hasNextInt()) s.next();
        int age = s.nextInt();
        KarvonenHeartRate kh = new KarvonenHeartRate(rp, age);
        System.out.println("Intensity\t| Rate");
        System.out.println("--------------------|-----------");
        for(int i = 55; i <= 95; i+= 5){
            System.out.println(i + "%\t" + kh.calculate(i) + " bpm");
        }
    }
}
