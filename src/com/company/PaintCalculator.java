package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by David on 1/22/2017.
 */
public class PaintCalculator {
    //a gallon covers 350 sq. ft.
    //round up to fully cover the project
    int gallonsNeeded, sqFt, lengthFt, widthFt;
    final int SQFTPERGALLON = 350;
    public PaintCalculator(int width, int length){
        this.lengthFt = length;
        this.widthFt = width;
        sqFt = length * width;
    }
    public void calcGallons(){
        double gallons = (double)sqFt / SQFTPERGALLON;
        gallonsNeeded = (int)(Math.ceil(gallons));
        System.out.println("You will need to purchase "+
        gallonsNeeded + " gallons of paint to cover " +
        sqFt + " square feet.");
    }

    public static void main(String[] args) {
        System.out.println("Enter length in feet:");
        Scanner s = new Scanner(System.in);
        boolean toContinue = false;
        int wide = 0, len = 0;
        while(!s.hasNextInt())s.next();

        len = s.nextInt();
        System.out.println("Enter the width in feet:");
        while(!s.hasNextInt()) s.next();
        wide = s.nextInt();

        new PaintCalculator(wide, len).calcGallons();

    }
}
