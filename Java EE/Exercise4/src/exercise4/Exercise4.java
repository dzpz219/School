package exercise4;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Exercise4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int totalNumbers = 5;
        int max = 0;
        int totalValue = 0;
        int counter = totalNumbers;
        int input;
        
        Scanner scan = new Scanner(System.in);
        while(counter > 0){
            System.out.println("Enter next integer:");
            input = scan.nextInt();
            max = input > max ? input : max; //checking if the input value is greater than the current max
            totalValue += input; //add input to existing total
            counter--;
        }
        
        System.out.println("Largest number is: " + max);
        System.out.println("The total of all numbers is: " + totalValue);
        System.out.println("The average of all the number is: " + (totalValue / totalNumbers));
        System.out.println("Program by Chao Zhang 000306946");
    }
    
}
