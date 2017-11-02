//I, Chao Zhang, 000306946 certify that this material is my original work. 
//No other person's work has been used without due acknowledgement.
package lab3;

import java.util.Scanner;

/**
 *
 * @author Chao
 */
public class CabSimulation {
    public static Double rate; //static rate variable
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cabID;
        Double weight;
        boolean inFront;
        
        Scanner input = new Scanner(System.in);
        System.out.println("What is today's rate?");
        rate = input.nextDouble();
        
        //Cab one and two
        Cab one = new Cab(1111);
        Cab two = new Cab(2222);
        one.setRate(rate);
        two.setRate(rate);
        
        System.out.print("Which cab? ");
        cabID = input.nextInt();
        
        //exit loop if cabID doesn't match existing ID
        while(cabID == one.getID() || cabID == two.getID()){
            System.out.print("New passenger weight (kg): ");
            weight = input.nextDouble();
            System.out.print("Passenger in front seat? (y/n) ");
            inFront = input.next().substring(0, 1).equalsIgnoreCase("y"); //check if first character is y
            Passenger p = new Passenger(weight, inFront);
            if(cabID == one.getID()){
                //cab one
                System.out.println(one.pickUp(p));
                System.out.print("How long is the trip in minutes? ");
                one.dropOff(input.nextInt());
            }
            else {
                //cab two
                System.out.println(two.pickUp(p));
                System.out.print("How long is the trip in minutes? ");
                two.dropOff(input.nextInt());
            }
            System.out.print("Which cab? ");
            cabID = input.nextInt();
        }
        //cab reports
        one.endOfShift();
        two.endOfShift();
        System.out.println(one.report());
        System.out.println(two.report());
    }
    
}
