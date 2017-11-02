/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise6;

/**
 *
 * @author Danny
 */
public class Employee {
    private String firstName;
    private String lastName;
    private Double totalPay = 0.0;
    
    public void setName(String nameFirst, String nameLast){
        this.firstName = nameFirst;
        this.lastName = nameLast;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    
    public void addPay(Double payAmount){
        this.totalPay += payAmount;
    }
    
    public void addPay(Double hourRate, Double numHours){
        Double total = hourRate * numHours;
        this.totalPay += total;
    }
    
    public Double getTotalPay(){
        return totalPay;
    }
}
