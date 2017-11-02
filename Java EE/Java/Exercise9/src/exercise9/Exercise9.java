/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Exercise9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int wordLength[] = new int[6];
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Sentence: ");
        
        String in = input.nextLine();
        
        String strArray[] = in.split(" ");
        
        for (int i = 0; i < strArray.length; i++){
            
            wordLength[strArray[i].length() - 1] ++;
            
        }
        
        for (int i = 0; i < wordLength.length; i++){
            
            System.out.print(i + 1 + "        ");
            System.out.println(wordLength[i]);
            
        }
    }
    
}
