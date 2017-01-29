package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by David on 1/29/2017.
 */
public class PickingWinners {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        while(true){
            System.out.println("Enter a name:(quit to end)");
            Scanner s = new Scanner(System.in);
            String curName = s.nextLine();
            if(curName.equalsIgnoreCase("quit"))
                break;
            else{
                names.add(curName);
            }
        }
        Random r = new Random();
        int c = r.nextInt(names.size());
        System.out.println("The winner is... " +
            names.get(c) + ".");
    }
}
