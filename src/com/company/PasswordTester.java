package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dfreer on 1/25/2017.
 */
public class PasswordTester {

    public static void testPW(){
        String pw;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a possible password:");
        pw = s.next();
        boolean allNumbers = true;
        for(int i = 0; i < pw.length(); i++){
            if(!Character.isDigit(pw.charAt(i)))
                allNumbers = false;
        }
        boolean allLetters = true;
        int numNumbers = 0, numLetters = 0;
        for(int i = 0; i < pw.length(); i++){
            if(!Character.isAlphabetic(pw.charAt(i)))
                allLetters = false;
        }

        for(int i = 0; i < pw.length(); i++){
            if(Character.isDigit(pw.charAt(i)))
                numNumbers++;
            if(Character.isAlphabetic(pw.charAt(i)))
                numLetters++;
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(pw);
        boolean specialCharacter = m.find();

        if(pw.length() < 8 && allNumbers)
            System.out.println("Very weak password.");
        else if(pw.length() < 8 && allLetters)
            System.out.println("Weak password.");
        else if(pw.length() >= 8 && numNumbers >= 1)
            System.out.println("Strong password.");
        else if(specialCharacter && numNumbers >= 1 && pw.length() >= 8 && numLetters >= 1)
            System.out.println("Very strong password.");
        else
            System.out.println("Weak password.");
        //instructions make this a bit unclear about how to deal with longer passwords...default weak?
    }

    public static void main(String[] args) {
        while(true)
            testPW();
    }
}
