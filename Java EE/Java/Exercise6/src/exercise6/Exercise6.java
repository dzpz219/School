package exercise6;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Exercise6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Employee emp = new Employee();
       Scanner input = new Scanner(System.in);
       
       System.out.print("Employee First Name: ");
       String first = input.next();
       System.out.print("Employee Last Name: ");
       String last = input.next();
       System.out.print("Enter lump-sum salary amount: ");
       Double sum = input.nextDouble();
       System.out.print("Enter hourly rate: ");
       Double hourlyRate = input.nextDouble();
       System.out.print("Enter number of hours: ");
       Double hours = input.nextDouble();
       
       emp.setName(first, last);
       emp.addPay(sum);
       emp.addPay(hourlyRate, hours);
       
       System.out.println("Total Pay for Employee " + emp.getName() + " is $" + emp.getTotalPay());
       System.out.println("Program by Chao Zhang 000306946");
    }
    
}
