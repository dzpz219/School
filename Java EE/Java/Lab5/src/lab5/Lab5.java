/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Danny
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sentence asd = new Sentence("Computer class (COMP10062) is cool.");
        Sentence asdf = new Sentence("The quick brown fox jumps over the lazy dogs.");
        System.out.println(asd);
        System.out.println(asd.isEncrypted());
       // System.out.println(26 % 3);
    }
}
