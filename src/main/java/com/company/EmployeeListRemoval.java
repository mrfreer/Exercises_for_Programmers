package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by David on 1/29/2017.
 */

class Employee{
    String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Employee)obj).name);
    }
}
public class EmployeeListRemoval {
    public static void main(String[] args) {
        ArrayList<Employee> allEmps = new
                ArrayList<>();
        int counter = 0;
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a name to add:");
            allEmps.add(new Employee(s.nextLine()));
            System.out.println("Enter q to stop entering names.");
            if(s.nextLine().equalsIgnoreCase("q"))
                break;
        }
        while(true) {
            System.out.println("Enter an employee to remove:");
            String name = s.nextLine();
            for(int i = 0; i < allEmps.size();i++){
                if(allEmps.get(i).equals(new Employee(name)))
                    allEmps.remove(i);
            }
            System.out.println("Enter q to stop entering names.");
            if (s.nextLine().equalsIgnoreCase("q"))
                break;
        }
        for(Employee e : allEmps){
            System.out.println(e.name);
        }
    }

}
