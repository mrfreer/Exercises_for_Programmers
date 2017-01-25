package com.company;

import java.util.Scanner;

/**
 * Created by dfreer on 1/25/2017.
 */
public class CarTroubleShooting {
    public void getUserInput(){
        Scanner s = new Scanner(System.in);

        System.out.println("Is your car alert when you turn on the key?");
        while(!s.hasNextBoolean()) s.next();
        boolean isAlert = s.nextBoolean();
        if(isAlert == true){
            System.out.println("Are the battery terminals corroded?");
            while(!s.hasNextBoolean()) s.next();
            boolean isCorroded = s.nextBoolean();
            if(isCorroded)
                System.out.println("Clean terminals and try starting again.");
            else
                System.out.println("Replace cables and try again.");
        }
        else{
            System.out.println("Does the car make a clicking noise?");
            while(!s.hasNextBoolean()) s.next();
            boolean makesClicking = s.nextBoolean();
            if(makesClicking){
                System.out.println("Replace the battery.");
            }
            else{
                System.out.println("Does the car crank up but fail to start?");
                while(!s.hasNextBoolean()) s.next();
                boolean crankNoStart = s.nextBoolean();
                if(crankNoStart){
                    System.out.println("Check spark plug connections.");
                }
                else{
                    System.out.println("Does the engine start and then die?");
                    while(!s.hasNextBoolean()) s.next();

                    boolean engineStartDie = s.nextBoolean();
                    if(engineStartDie){
                        System.out.println("Does your car have fuel injection?");
                        while(!s.hasNextBoolean()) s.next();
                        boolean fuelInjection = s.nextBoolean();
                        if(fuelInjection){
                            System.out.println("Get it in for service.");
                        }
                        else
                        {
                            System.out.println("Check to ensure the choke is opening and closing.");
                        }
                    }
                }
            }
        }



    }

    public static void main(String[] args) {
        new CarTroubleShooting().getUserInput();
    }
}
