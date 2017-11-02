//I, Chao Zhang, 000306946 certify that this material is my original work. 
//No other person's work has been used without due acknowledgement.

package lab1;
/**
 * @author Danny
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;    
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Lists for customer order and store items
        List<Order> orderList=new ArrayList<>();
        List<Item> itemList=new ArrayList<>();

        Double HST;
        Double saleDiscount;
        Double subTotal1 = 0.00;
        Double subTotal2;
        Double discountPercent = 0.00;
        Double total;
        
        // Store items
        Item itemOne = new Item("T-Shirt", 5.99);
        Item itemTwo = new Item("Sweater", 9.99);
        Item itemThree = new Item("Jeans", 15.99);
        Item itemFour = new Item("Socks", 1.99);
        Item itemFive = new Item("Shorts", 6.99);
        
        // Item on sale
        String saleItem = "Socks";
        
        // Add the items to store's item list
        itemList.add(itemOne);
        itemList.add(itemTwo);
        itemList.add(itemThree);
        itemList.add(itemFour);
        itemList.add(itemFive);
        
        // Scanner for user's inputs
        Scanner input = new Scanner(System.in);
        
        // Input Block
        System.out.println("Welcome to Past 7 Clothing, orders of over $100.00 will pay no HST! \nPlease tell us your Name, Phone Number and Postal Code.");
        
        System.out.print("Name: ");
        String name = input.nextLine();
        
        System.out.print("Phone Number: ");
        String number = input.nextLine();
        
        System.out.print("Postal: ");
        String postal = input.nextLine();
        
        Customer customer = new Customer(name, number, postal);

        // Iterate through the store's item list
        // and prompt user for Y/N answer
        // to order items
        for(Item i:itemList){
            // Different output for sale item
            if (i.getName().equalsIgnoreCase(saleItem)){
                System.out.println("Would you like to order " + i.getName() + " for " + i.getPrice() + "? (Y/N)\nWe're having a sale buy 2 get the 3rd FREE!");
            }
            else{
                System.out.println("Would you like to order " + i.getName() + " for " + i.getPrice() + "? (Y/N)");
            }

            // Prompt user for number of items they want to order
            // and create the order and add it to order list
            if (input.next().equalsIgnoreCase("y")){
                System.out.println("How many " + i.getName() + " would you like to order?");
                Order o = new Order(i, input.nextInt());
                orderList.add(o);
            }
        }
        
        // Prompt user for additional discount
        System.out.println("Any additional discounts? (0 - 100 percent)");
        discountPercent = input.nextDouble()/100;
        
        // Output Block
        System.out.println("--------------------------------------------------");
        System.out.println("Past 7 Clothing, 182 Clothing Avenue, 905-123-1123");
        System.out.println("--------------------------------------------------");
        System.out.printf("%s%38s\n%50s\n%50s\n" , "Invoice for:", customer.getName(), customer.getNumber(), customer.getPostal());
        System.out.println("--------------------------------------------------");
        System.out.printf("%s%15s%26s\n", "Item", "Amount", "Cost");
        
        // Processing Block
        for(Order o:orderList){
            // total cost of multiple orders of same item
            Double itemtotal = o.getAmount().doubleValue() * o.getItem().getPrice();
            
            // if the item is the sale item, display the amount of free items
            // subtract the free item cost from item total cost
            if (o.getItem().getName().equalsIgnoreCase(saleItem)){
                saleDiscount = (o.getAmount() / 3) * o.getItem().getPrice();
                itemtotal -= saleDiscount;
                System.out.printf("%-13s%-27d $%.2f\n", o.getItem().getName(), o.getAmount(), itemtotal);
                System.out.printf("%-50s\n", o.getAmount()/3 + " Free pairs");
            }
            else{
                System.out.printf("%-13s%-27d $%.2f\n", o.getItem().getName(), o.getAmount(), itemtotal);
            }
            
            // keep track of subtotal
            subTotal1 += itemtotal;
        }
         
        // Output Block
        System.out.println("--------------------------------------------------");
        
        // HST check if subTotal1 is more than 100, HST is 0
        HST = subTotal1 > 100? 0.00 : 0.13; 
        System.out.printf("%40s $%.2f\n", "Subtotal 1:", subTotal1);
        System.out.printf("%40s $%.2f\n", "HST:", HST * subTotal1);
        subTotal2 = subTotal1 * (1 + HST);
        System.out.printf("%40s $%.2f\n", "Subtotal 2:", subTotal2);
        System.out.printf("%40s $%.2f\n", "Discount Amount:", subTotal2 * discountPercent);
        total = subTotal2 * (1 - discountPercent);
        System.out.printf("%40s $%.2f\n", "Total:", total);
    }    
}
