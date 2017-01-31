package com.company;

import java.util.Random;

class Madlib{
    //noun, verb, adjective, adverb
    String noun, verb, adjective, adverb;
    public Madlib(String noun, String verb, String adjective, String adverb){
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.adverb = adverb;
    }


    public void createStory(){
        Random r = new Random(System.currentTimeMillis());
        int curNum = r.nextInt(2);
        System.out.println(curNum);
        if(curNum == 0)
        {
            System.out.println("Do you take your " + noun + " for a " +
            verb + " " + adverb + " if you have a " + adjective + " house?" + '\n');
        }
        else
            System.out.println("If a " + noun + " came over to " + verb + " " +
            adverb + " it would need a " + adjective + " car.\n");

    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Madlib m = new Madlib("dog", "bark", "giant", "quickly");
        m.createStory();
    }
}
