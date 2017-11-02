/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palidrome;

/**
 *
 * @author Danny
 */
public class Palidrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel sees Leddon."));
    }
    
    public static boolean isPalindrome(String str) {
        String trimString = str.replaceAll("[^A-Za-z]+", "").toUpperCase();
        String reverseString = new StringBuilder(trimString).reverse().toString();
        return trimString.matches(reverseString);
    }

    
}
