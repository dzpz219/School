/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("Enter:");
       String s = "";
       String x = "";
       do {
           x = input.nextLine().trim();
           if (!x.equals("quit")){
               s = x.concat(s);
           }
       }    while(!x.equals("quit"));   
    System.out.println(s);
    }
    
}
