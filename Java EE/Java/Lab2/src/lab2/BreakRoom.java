//I, Chao Zhang, 000306946 certify that this material is my original work. 
//No other person's work has been used without due acknowledgement.
package lab2;

import java.util.Scanner;

/**
 *
 * @author Chao
 */
public class BreakRoom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VendingMachine v1 = new VendingMachine("Coke", "Pepsi", 1.00, 1.50, 10, 5);
        VendingMachine v2 = new VendingMachine("Lays", "Pringles", 2.00, 2.50, 15, 10);
        System.out.println("Welcome to the Break Room!\nThere are two vending machines here:\n");
        System.out.println("Machine One:\n" + v1.toString());
        System.out.println("----------------------------------------------------");
        System.out.println("Machine Two:\n" + v2.toString());
        System.out.println("----------------------------------------------------\n");
        System.out.println("What would you like to do?\n"
                + "1. Enter money\n"
                + "2. Get change back\n"
                + "3. Vend an item\n"
                + "4. Restock a machine\n"
                + "5. Get a profit report\n"
                + "6. Leave the break room\n"
                + "Your Choice?");
        int i = input.nextInt(); // Vending machine choice
        while (i != 6){ //Enter 6 to exit menu
            switch(i){
                case 1: //Enter money into vending machine 1 or 2
                    System.out.println("Please choose a vending machine: 1 or 2, 0 to go back");
                    int vm = input.nextInt();
                    if (vm == 0) break; //0 to go back to previous menu
                    else if (vm == 1 || vm == 2) {
                        System.out.println("Choose a coin type:\n"
                            + "1. Toonie 2. Loonie 3. Quarter 4. Dime 5. Nickel 6. Back");
                            int coin = input.nextInt();
                            while (coin != 6){ //Enter 6 to exit menu
                                switch (coin){
                                case 1:
                                    if (vm == 1){
                                        v1.insertToonie();
                                        System.out.printf("%s$%.2f%s", "Machine 1 Current Credit: ", v1.getCredit(), "\n------------------------------\n");
                                      }
                                    else {
                                        v2.insertToonie();
                                        System.out.printf("%s$%.2f%s", "Machine 2 Current Credit: ", v2.getCredit(), "\n------------------------------\n");
                                    }
                                    break;
                                case 2:
                                    if (vm == 1){
                                        v1.insertLoonie();
                                        System.out.printf("%s$%.2f%s", "Machine 1 Current Credit: ", v1.getCredit(), "\n------------------------------\n");
                                      }
                                    else {
                                        v2.insertLoonie();
                                        System.out.printf("%s$%.2f%s", "Machine 2 Current Credit: ", v2.getCredit(), "\n------------------------------\n");
                                    }
                                    break;
                                case 3:
                                    if (vm == 1){
                                        v1.insertQuarter();
                                        System.out.printf("%s$%.2f%s", "Machine 1 Current Credit: ", v1.getCredit(), "\n------------------------------\n");
                                      }
                                    else {
                                        v2.insertQuarter();
                                        System.out.printf("%s$%.2f%s", "Machine 2 Current Credit: ", v2.getCredit(), "\n------------------------------\n");
                                    }
                                    break;
                                case 4:
                                    if (vm == 1){
                                        v1.insertDime();
                                        System.out.printf("%s$%.2f%s", "Machine 1 Current Credit: ", v1.getCredit(), "\n------------------------------\n");
                                      }
                                    else {
                                        v2.insertDime();
                                        System.out.printf("%s$%.2f%s", "Machine 2 Current Credit: ", v2.getCredit(), "\n------------------------------\n");
                                    }
                                    break;
                                case 5:
                                    if (vm == 1){
                                        v1.insertNickel();
                                        System.out.printf("%s$%.2f%s", "Machine 1 Current Credit: ", v1.getCredit(), "\n------------------------------\n");
                                      }
                                    else {
                                        v2.insertNickel();
                                        System.out.printf("%s$%.2f%s", "Machine 2 Current Credit: ", v2.getCredit(), "\n------------------------------\n");
                                    }
                                    break;
                                default:
                                    break;
                                }
                                System.out.println("Choose a coin type:\n"
                            + "1. Toonie 2. Loonie 3. Quarter 4. Dime 5. Nickel 6. Back");
                                coin = input.nextInt();
                            }
                    }
                    break;
                case 2: //Get change back from vending machine 1 or 2
                    System.out.println("Please choose a vending machine: 1 or 2, 0 to go back");
                    vm = input.nextInt();                   
                    switch (vm){
                        case 0: //0 to go back to previous menu
                            break;
                        case 1:
                            System.out.printf("Vending Machine 1 Coin Return: $%.2f\n", v1.coinReturn());
                            break;
                        case 2:
                            System.out.printf("Vending Machine 2 Coin Return: $%.2f\n", v2.coinReturn());
                            break;
                        default:
                            break;
                    }
                    break;
                case 3: //Vend an item from machine 1 or 2, product 1 or 2
                    System.out.println("Please choose a vending machine: 1 or 2, 0 to go back");
                    int product;
                    vm = input.nextInt();
                    String vend;
                    switch (vm){
                        case 0: //0 to go back to previous menu
                            break;
                        case 1:
                            System.out.println("Which item?\n1: " + v1.getProduct1() + "\n2: " + v1.getProduct2() + "\n");
                            product = input.nextInt();
                            vend = (v1.vend(product)) ? "Successfully purchased" : "Failed to purchase";
                            System.out.println(vend + "\n");
                            break;
                        case 2:
                            System.out.println("Which item?\n1: " + v2.getProduct1() + "\n2: " + v2.getProduct2() + "\n");
                            product = input.nextInt();
                            vend = (v2.vend(product)) ? "Successfully purchased" : "Failed to purchase";
                            System.out.println(vend + "\n");
                            break;
                        default:
                            break;
                    }
                    break;
                case 4: //Restock an item from machine 1 or 2 product 1 or 2, new stock number
                    System.out.println("Please choose a vending machine: 1 or 2, 0 to go back");
                    int stock1;
                    int stock2;
                    vm = input.nextInt();
                    switch (vm){
                        case 0: //0 to go back to previous menu
                            break;
                        case 1:
                            System.out.println("How many to restock for product 1?");
                            stock1 = input.nextInt();
                            System.out.println("How many to restock for product 2?");
                            stock2 = input.nextInt();
                            v1.restock(stock1, stock2);
                            break;
                        case 2:
                            System.out.println("How many to restock for product 1?");
                            stock1 = input.nextInt();
                            System.out.println("How many to restock for product 2?");
                            stock2 = input.nextInt();
                            v2.restock(stock1, stock2);
                            break;
                        default:
                            break;
                    }
                    break;
                case 5: //Display credit and total from both machine
                    System.out.printf("Machine One\n"
                            + "Credits: $%.2f\n"
                            + "Total: $%.2f\n"
                            + "Machine Two\n"
                            + "Credits: $%.2f\n"
                            + "Total: $%.2f\n", v1.getCredit(), v1.getTotal(), v2.getCredit(), v2.getTotal());
                    break;
                default:
                    break;
            }
            
            System.out.println("Welcome to the Break Room!\nThere are two vending machines here:\n");
            System.out.println("Machine One:\n" + v1.toString());
            System.out.println("----------------------------------------------------");
            System.out.println("Machine Two:\n" + v2.toString());
            System.out.println("----------------------------------------------------\n");
            System.out.println("What would you like to do?\n"
                + "1. Enter money\n"
                + "2. Get change back\n"
                + "3. Vend an item\n"
                + "4. Restock a machine\n"
                + "5. Get a profit report\n"
                + "6. Leave the break room\n"
                + "Your Choice?\n");
            i = input.nextInt();
        }
    }
}
