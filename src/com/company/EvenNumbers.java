package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dfreer on 1/30/2017.
 */
public class EvenNumbers {
    int userNums[];
    public void enterNums(){
        System.out.println("Enter a list of numbers separated by spaces:");
        Scanner r = new Scanner(System.in);
        String userInput = r.nextLine();
        String [] allNums = userInput.split(" ");
        int counter = 0;
        userNums = new int[allNums.length];
        for(String a : allNums){
            try {
                userNums[counter] = Integer.parseInt(a);
                counter++;
            }catch (NumberFormatException nf){
                System.out.println("You entered a non-number.");
                nf.printStackTrace();
            }

        }

    }


    public int[] filterNums(){
        int allEvens[] = new int[userNums.length];
        int counter = 0;
        for(Integer i : userNums){
            if(i % 2 == 0){
                allEvens[counter] = i;
                counter++;
            }

        }
        int onlyEvens[] = Arrays.copyOf(allEvens, counter);
        return onlyEvens;
    }

    public static void main(String[] args) {
        EvenNumbers e = new EvenNumbers();
        e.enterNums();
        int [] evens = e.filterNums();
        System.out.println(evens.length);
        for(Integer a : evens)
            System.out.println(a);
    }
}
