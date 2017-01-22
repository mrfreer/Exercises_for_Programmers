package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by David on 1/22/2017.
 */
public class RetirementCalendar {

    private int curYear, curAge, retirementAge, yearsToRetire = 0, retirementYear;
    public RetirementCalendar(int curAge, int retirementAge){
        this.curAge = curAge;
        this.retirementAge = retirementAge;
        curYear = Calendar.getInstance().get(Calendar.YEAR);
        yearsToRetire = retirementAge - curAge;
        retirementYear = curYear + yearsToRetire;
    }

    public int calcYears(){
        return yearsToRetire;
    }

    public int yearOfRetirement(){
        return retirementYear;
    }

    public static void main(String[] args) {
        System.out.println("Enter your current age: ");
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        while(c <= 0)
        {
            System.out.println("Age must be over 0.");
            c = s.nextInt();
        }
        System.out.println("Enter desired retirement age:");
        int r = s.nextInt();
        while(r <= 0)
        {
            System.out.println("Age must be over 0.");
            r = s.nextInt();
        }
        RetirementCalendar rc = new RetirementCalendar(c, r);
        System.out.println("You have " + rc.yearsToRetire + " years left until you can retire.");
        System.out.println("You can retire in the year " + rc.retirementYear);

    }
}
