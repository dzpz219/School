/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class Exercise8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        
        Scanner input = new Scanner(System.in);
        String first = "";
        while(!first.equalsIgnoreCase("end")){
            Employee emp = new Employee();
            System.out.print("Employee First Name: ");
            first = input.next();
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
            employees.add(emp);
        }
        for (Employee e : employees) {
                System.out.println(e.getName());
                System.out.println(e.getTotalPay());
            }
            
            System.out.println(employees.size());
    }
}
