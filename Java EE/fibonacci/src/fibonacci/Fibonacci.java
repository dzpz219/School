/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Danny
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int numberOfWays(int n) {
        int first = 0, second = 1, sum = 0;
        if(n == 1 || n == 2){
            return n;
        }
        else {
            for (int i = 2; i <= n+1; i++)
            {
                sum = first + second;  
                first = second;  
                second = sum;  
            }
            return sum;
        }
    }
    
}
