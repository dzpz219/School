package exercise5;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Exercise5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int totalNumbers;
        int max = 0;
        int counter;
        int input;
        int totalValue = 0;
        int average;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("How many grades to enter? ");
        totalNumbers = scan.nextInt();
        counter = totalNumbers;
        
        while(counter > 0){
            System.out.print("Enter next grade (0 to 5): ");
            input = scan.nextInt();
            //only add the input to total value if it is 0 to 5
            if (input <= 5 && input >= 0){
                totalValue += input;   
            }
            else {
                totalNumbers --; //remove invalid number from count
            }
            
            // grades of 0 - 3 are set to 0, which is a C
            input = input < 3 && input >= 0 ? 0 : input;
            switch (input){
                case 5:
                    System.out.println("The letter grade is A");
                    break;
                case 4:
                    System.out.println("The letter grade is B");
                    break;
                case 3:
                    System.out.println("The letter grade is C");
                    break;
                case 0:
                    System.out.println("This is a failing grade");
                    break;
                default:
                    System.out.println("Invalid grade");
                    break;
            }
            counter --;
        }
        //only calculate average if the total numbers is more than 0
        if (totalNumbers > 0){
            average = totalValue / totalNumbers;
            System.out.println("The average grade is: " + average);
        }
        else {
            System.out.println("Invalid average");
        }
        System.out.println("Program by Chao Zhang 000306946");
    }
}
