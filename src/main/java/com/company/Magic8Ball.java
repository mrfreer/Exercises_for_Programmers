package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by David on 1/28/2017.
 */
public class Magic8Ball {
    private String question;
    private String [] answers = {"Yes", "No", "Maybe", "Ask again later"};

    public void askQuestion(){
        Scanner s = new Scanner(System.in);
        System.out.println("What's your question?");
        String q = s.nextLine();
        question = q;
    }

    public void giveAnswer(){
        Random r = new Random();
        int num = r.nextInt(4);
        System.out.println(answers[num]);
    }

    public static void main(String[] args) {
        Magic8Ball m = new Magic8Ball();
        m.askQuestion();
        m.giveAnswer();
    }
}
