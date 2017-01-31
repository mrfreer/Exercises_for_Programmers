package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by David on 1/29/2017.
 */
public class PasswordGenerator {

    int minLength, specialChars, nums;
    public PasswordGenerator(int m, int s, int n){
        minLength = m;
        specialChars = s;
        nums = n;
    }

    public String returnPassword(){
        //33-47 special character
        //48-57 numbers
        //58-64 special character
        //65-90 capitals
        //97-122 lowercase
        Random r = new Random();
        int counter = 0;
        char allWord [] = new char[minLength];

            for(int j = 0; j < specialChars; j++){
                allWord[counter] = (char)(ThreadLocalRandom.current().nextInt(33,46));
                counter++;
            }
            for(int j = 0; j < nums; j++){
                 allWord[counter] = (char)(ThreadLocalRandom.current().nextInt(48,57));
                 counter++;
            }
            for(int j = 0; j < minLength - (specialChars + nums); j++){
                allWord[counter] = (char)(ThreadLocalRandom.current().nextInt(65,90));
                counter++;
            }
            String sb = new String(allWord);
            List<String> letters = Arrays.asList(sb.split(""));
            Collections.shuffle(letters);
            String shuffled = "";
            for(String letter: letters)
                shuffled += letter;
        return shuffled;
    }

    public static void main(String[] args) {
        System.out.println("Length of password:");
        Scanner s = new Scanner(System.in);
        while(!s.hasNextInt()) s.next();
        int l = s.nextInt();
        System.out.println("Number of special characters:");
        while(!s.hasNextInt()) s.next();
        int sp = s.nextInt();
        System.out.println("Number of numbers:");
        while(!s.hasNextInt()) s.next();
        int nums = s.nextInt();
        PasswordGenerator g = new PasswordGenerator(l, sp, nums);
        System.out.println(g.returnPassword());
    }
}
