package exercise3;
import java.util.Scanner;
/**
 * @author Danny
 */
public class Exercise3 {

    public static void main(String[] args) {
        
        // Instanciate two account instances
        Account first = new Account("Harriet Jones", 40.00);
        Account second = new Account("Jack Harkness", 75.50);
        
        // print out initial balance for both of the accounts
        System.out.println("Balance for " + first.getName() + ": $" + first.getBalance());
        System.out.println("Balance for " + second.getName() + ": $" + second.getBalance());
        
        // create new scanner object to prompt user input      
        Scanner input = new Scanner(System.in);
        
        // prompt user for deposit and withdraw amounts
        System.out.println("Please enter deposit amount for " + first.getName());
        first.deposit(input.nextDouble());
        System.out.println("Please enter withdraw amount for " + second.getName());
        second.withdraw(input.nextDouble());
        
        // output results of account balances after user input
        System.out.println("Balance for " + first.getName() + ": $"+ first.getBalance());
        System.out.println("Balance for " + second.getName() + ": $" + second.getBalance());
        System.out.println("Program by Chao Zhang, 000306946");
    }
}
