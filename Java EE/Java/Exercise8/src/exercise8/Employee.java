/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise8;

/**
 *
 * @author Danny
 */
public class Employee {
    private String firstName;
    private String lastName;
    private double totalPay;
    
    public void setName( String nameFirst, String nameLast){
        this.firstName = nameFirst;
        this.lastName = nameLast;
    }
    
    public String getName(){
        return this.firstName + " " + this.lastName;
    }
    
    public void addPay(double payAmount){
        totalPay = totalPay + payAmount;
    }
    
    public void addPay(double hourRate, double numHours){
        totalPay = totalPay + (hourRate * numHours);
    }
    
    public double getTotalPay(){
        return this.totalPay;
    }
}
