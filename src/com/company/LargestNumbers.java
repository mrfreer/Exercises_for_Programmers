package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by dfreer on 1/25/2017.
 */
public class LargestNumbers {
    TreeSet<Integer> nums = new TreeSet<>();

    public LargestNumbers(){

    }

    public int getLargestNum(){
        return nums.last();
    }
    public void getUserNums(){
        while(true){
            System.out.println("Enter a number:");
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()) s.next();
            int curNumber = s.nextInt();
            if(nums.contains((int)curNumber))
            {
                System.out.println("Already entered.");
            }
            else{
                nums.add(curNumber);
            }
            System.out.println("Do you wish to quit?  Enter 1 to quit.");
            while(!s.hasNextInt()) s.next();
            if(s.nextInt() == 1)
                break;
        }
    }

    public static void main(String[] args) {
        LargestNumbers ln = new LargestNumbers();
        ln.getUserNums();
        System.out.println(ln.getLargestNum());
    }
}
