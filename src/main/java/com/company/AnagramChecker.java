package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dfreer on 1/25/2017.
 */
public class AnagramChecker {
    String word1 = "", word2 = "";
    public void enterWords(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        System.out.println("Enter the first string:");
        word1 = s.next();
        System.out.println("Enter the second string:");
        word2 = s.next();
    }

    public boolean arePalindromes(){
        if(word1.length() != word2.length())
            return false;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(word2.length()-i-1))
                return false;
        }
        return true;
    }

    public boolean areAnagrams(){
        if(word1.length() != word2.length())
            return false;
        for(int i = 0; i < word1.length(); i++){
            if(!word2.contains(word1.substring(i,i+1)))
                return false;
        }
        return true;
        //not sure if this will always work...
    }

    public boolean areAnagramsBetter(){

        char [] w1 = word1.toLowerCase().toCharArray();
        char [] w2 = word2.toLowerCase().toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        if(Arrays.equals(w1, w2))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        AnagramChecker a = new AnagramChecker();
        a.enterWords();
        if(a.arePalindromes())
            System.out.println(a.word1 + " and " + a.word2 + " are palindromes.");
        else
            System.out.println("NOT palindromes.");

        if(a.areAnagrams())
            System.out.println(a.word1 + " and " + a.word2 + " are anagrams.");
        else
            System.out.println("NOT anagrams.");

        if(a.areAnagramsBetter())
            System.out.println(a.word1 + " and " + a.word2 + " are anagrams.");
        else
            System.out.println("NOT anagrams.");
    }
}
