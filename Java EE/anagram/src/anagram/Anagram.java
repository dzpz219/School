/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.Arrays;

/**
 *
 * @author Danny
 */
public class Anagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(areAnagrams("neural", "unreal"));
    }
    
    public static boolean areAnagrams(String a, String b) {
        char[] firstWord = a.replaceAll("[^A-Za-z]+", "").toCharArray();
        char[] secondWord = b.replaceAll("[^A-Za-z]+", "").toCharArray();
        Arrays.sort(firstWord);
        Arrays.sort(secondWord);
        //return firstWord.equals(secondWord);
        //return Arrays.equals(firstWord, secondWord);
    }
}
