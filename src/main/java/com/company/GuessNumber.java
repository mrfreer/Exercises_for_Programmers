package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by David on 1/27/2017.
 */
public class GuessNumber {
    //guess
    private int guess, randomNum, level, tries = 0;
    //random number
    public GuessNumber(int guess, int level){
        this.guess = guess;
        Random r = new Random();
        this.level = level;
        if(level == 1)
            randomNum = r.nextInt(10);
        else if(level == 2)
            randomNum = r.nextInt(100);
        else if(level == 3)
            randomNum = r.nextInt(1000);
    }

    public void makeNewGuess(int g){
        guess = g;
    }

    public String highOrLow(){
        tries++;
        if(guess > randomNum)
            return "Too high.";
        else if(guess < randomNum)
            return "Too low.";
        else
            return "You got it in " + tries + ".";
    }

    public static void main(String[] args) {
        String playAgain = "q";
        do{
        System.out.println("Let's play Guess the Number.");
        System.out.println("Pick a difficulty level " +
                "(1,2, or 3):");
        Scanner s = new Scanner(System.in);
        while (!s.hasNextInt()) s.next();
        int level = s.nextInt();
        while (level > 3 || level < 0) {
            System.out.println("Number must be 1,2,3:");
            while (!s.hasNextInt()) s.next();
            level = s.nextInt();
        }

        System.out.println("Make a guess:");
        while (!s.hasNextInt()) s.next();
        int guess = s.nextInt();

        GuessNumber g = new GuessNumber(guess, level);
        boolean continueGuessing = true;
        while (continueGuessing) {

            String result = g.highOrLow();
            if (result.equals("Too high.") ||
                    result.equals("Too low.")){
                System.out.println(result);
                System.out.println("Make a guess:");
                while (!s.hasNextInt()) s.next();
                guess = s.nextInt();
                g.makeNewGuess(guess);
            }
            else {
                System.out.println(result);
                continueGuessing = false;
            }

        }
            System.out.println("Play again? 'n' to quit");

            playAgain = s.next();
        }while(!playAgain.equals("n"));


    }
}
