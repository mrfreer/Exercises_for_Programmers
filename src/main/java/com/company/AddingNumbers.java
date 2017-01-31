package com.company;

import java.util.Scanner;

/**
 * Created by dfreer  on 1/27/2017.
 */
public class AddingNumbers {
    public static void main(String[] args) {
        int nums[] = new int[5];
        Scanner s = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            System.out.println("Enter a number:");
            while(!s.hasNextInt()) s.next();
            nums[i] = s.nextInt();
            sum += nums[i];
        }
        System.out.println("The sum is " + sum);
        System.out.println("DF");
    }
}
