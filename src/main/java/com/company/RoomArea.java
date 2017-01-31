package com.company;

import java.util.Scanner;

/**
 * Created by David on 1/22/2017.
 */
public class RoomArea {
    final double CONVERSION = .3048;
    private double length, width, area_Ft, area_Mt, lenMeters, widMeters;
    public RoomArea(double len, double wid){
        length = len;
        width = wid;
        calcMeters();
    }

    void calcMeters(){
        lenMeters = length * CONVERSION;
        widMeters = width * CONVERSION;
    }

    double calcAreaFt(){
        return length * width;
    }

    double calcAreaMet(){
        return lenMeters * widMeters;
    }

    public static void main(String[] args) {
        System.out.println("What is the length of the room (in feet)?");
        Scanner s = new Scanner(System.in);
        double len = s.nextDouble();
        System.out.println("What is the width of the room (in feet)?");
        double w = s.nextDouble();
        RoomArea r = new RoomArea(len, w);
        double areaMeters = r.calcAreaMet();
        double areaFeet = r.calcAreaFt();
        System.out.println("You entered dimensions of " +
                            len + " and " + w + " feet.");
        System.out.println("The area is " + "\n" + areaFeet + " square feet" +
                            "\n" + areaMeters + " square meters");
    }
}
