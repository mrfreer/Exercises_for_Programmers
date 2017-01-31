package com.company;

import java.util.Scanner;

/**
 * Created by David on 1/24/2017.
 */
public class LegalAge {


    public static void main(String[] args) {
        final int LEGAL_AGE = 16;
        Scanner s = new Scanner(System.in);
        System.out.println("What is your age?");
        while(!s.hasNextInt()) s.next();
        int userAge = s.nextInt();

        String output = (userAge >= LEGAL_AGE) ? "You are old enough to legally drive." :
                "You are not old enough to legally drive.";
        System.out.println(output);
    }
}
