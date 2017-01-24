package com.company;

import java.io.Console;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by David on 1/24/2017.
 */
public class PasswordValidation {
    HashMap map = new HashMap<String, String>();
    public PasswordValidation(){
        map.put("David", "password");
        map.put("Sandy", "bobross");
    }

    public void getInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter user:");
        String user = s.nextLine();
        System.out.println("Enter password?");
        String u_password = s.nextLine();
        checkInput(user, u_password);
    }

    public boolean checkInput(String u, String p){
        while(map.containsKey(u)){
            if(map.get(u).equals(p)){
                System.out.println("Welcome!");
                return true;
            }
            else{
                System.out.println("Incorrect password.");
                return false;

            }

        }
        return false;
    }

    public static void main(String[] args) {
        PasswordValidation pw = new PasswordValidation();
        pw.getInput();

    }
}
