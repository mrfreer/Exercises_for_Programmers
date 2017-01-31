package com.company;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by David on 1/27/2017.
 */
public class EmployeeInfo {
    private String firstN, lastN, ID;
    private int zip;

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "firstN='" + firstN + '\'' +
                ", lastN='" + lastN + '\'' +
                ", ID='" + ID + '\'' +
                ", zip=" + zip +
                '}';
    }

    public EmployeeInfo(){

    }

    public EmployeeInfo(String firstN, String lastN, String ID, int zip) {
        this.firstN = firstN;
        this.lastN = lastN;
        this.ID = ID;
        this.zip = zip;
    }

    public EmployeeInfo makeEmp(){
        return new EmployeeInfo(firstN, lastN, ID, zip);
    }

    public void readInput(){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Enter the first name:");
            firstN = s.nextLine();
            if(firstN.length() >= 2)
                break;
        }

        while(true){
            System.out.println("Enter the last name:");
            lastN = s.nextLine();
            if(firstN.length() >= 2)
                break;
        }
        while(true){
            System.out.print("Enter the employee id ");
            System.out.println("Must have two letters, hyphen and four numbers.");
            System.out.println("Example: AB-1234");
            Pattern p = Pattern.compile(
                    "[a-zA-Z][a-zA-Z]-\\d\\d\\d\\d");
            Matcher m = p.matcher(s.next());
            if(m.matches())
                break;
        }
        System.out.println("Enter zip code:");
        while(!s.hasNextInt()) s.next();
        zip = s.nextInt();

        System.out.println(firstN + " " + lastN +
        " " + zip + " " + ID);

    }

    public static void main(String[] args) {
        EmployeeInfo newE = new EmployeeInfo();
        newE.readInput();
        EmployeeInfo newF = newE.makeEmp();
        System.out.println(newE);
        System.out.println(newF);
        //thinking about different ways to make objects

    }
}
