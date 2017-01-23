package com.company;

import java.util.Scanner;

/**
 * Created by David on 1/22/2017.
 */
public class PizzaDivision {
    private int numPeople, numPizzas, remainder, numPerPerson,
            slicesPerPerson, slicesPerPizza;
    public PizzaDivision(int numPeople, int numPizzas, int slicesPerPizza){
        this.numPeople = numPeople;
        this.numPizzas = numPizzas;
        this.slicesPerPizza = slicesPerPizza;
    }

    public void setSlicesPerPerson(){
         //numpizzas * numslicesperpizza
        int totalslices = numPizzas * slicesPerPizza;

        int yourShare = ((int)(totalslices)) / numPeople;

        remainder = totalslices - (yourShare * numPeople);
        if(yourShare == 1)
            System.out.println("Each person gets " + yourShare + " slice.");
        else
            System.out.println("Each person gets " + yourShare + " slices.");
        System.out.println("Remainder: " + remainder);
    }

    public static void main(String[] args) {
        System.out.println("How many people?");
        Scanner s = new Scanner(System.in);
        int numPeople = s.nextInt();
        System.out.println("How many pizzas do you have?");
        int numPizzas = s.nextInt();
        System.out.println("How many slices per pizza?");
        int nmSlices = s.nextInt();
        PizzaDivision p = new PizzaDivision(numPeople, numPizzas, nmSlices);
        p.setSlicesPerPerson();
    }
}
