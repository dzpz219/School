/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.GregorianCalendar;

/**
 *
 * @author Danny
 */
@ManagedBean
@Named(value = "mortgage")
@RequestScoped
public class Mortgage {
    /**
     * Creates a new instance of Mortgage
     */
    public Mortgage() {
        
    }
    
    //Validation for amortization period
    @Min(5)
    @Max(30)
    @NotNull
    private double amortizationPeriod = 25.0;
    
    //Validation for amount
    @Min(10000)
    @Max(1000000)
    @NotNull
    private double amount = 200000.0;

    private double interestRate = 6.0;
    private double calculatedMonthlyRate;
    private double effectiveAnnualRate;
    private double totalInterest;
    private double totalAmount;
    private ArrayList<Payment> payments = new ArrayList<>();
    
    /**
     * Creates an arraylist of payments
     *
     * @return the value of payments
     */
    public ArrayList<Payment> getPayments() {   
        double months = amortizationPeriod * 12;
        double balance = amount;
        double monthlyPay = (calculatedMonthlyRate * amount / 100.0)/(1.0 - Math.pow((1.0 + calculatedMonthlyRate / 100.0), -300.0));
        Calendar cal = new GregorianCalendar();
        
        //Iterates the amount of months
        //adds one payment object to payments each iteration
        for (int i = 0; i < months; i++){
            Payment pay = new Payment();
            pay.setDate(cal);
            pay.setPrinciple(monthlyPay - calculatedMonthlyRate / 100.0 * balance);
            pay.setBalance(balance - pay.getPrinciple());
            pay.setPayment(monthlyPay);
            pay.setInterest(calculatedMonthlyRate / 100.0 * balance);
            
            payments.add(pay);
            balance = balance - pay.getPrinciple();
        }
        return payments;
    }
    
    /**
     * Get the value of totalInterest
     *
     * @return the value of totalInterest
     */
    public double getTotalInterest() {
        totalInterest = getTotalAmount() - amount;
        return totalInterest;
    }

    /**
     * Get the value of totalAmount
     *
     * @return the value of totalAmount
     */
    public double getTotalAmount() {
        double interest = getCalculatedMonthlyRate();
        totalAmount = (((interest/100) * amount)/(1.0-(Math.pow(1.0+(interest/100), -(amortizationPeriod * 12.0)))) * amortizationPeriod * 12.0);
        return totalAmount;
    }


    /**
     * Get the value of calculatedSemiAnnualRate
     *
     * @return the value of calculatedSemiAnnualRate
     */
    public double getEffectiveAnnualRate() {
        effectiveAnnualRate = (Math.pow((1.0 + (interestRate/200.0)), 2.0) - 1.0) * 100;
        return effectiveAnnualRate;
    }

    

    /**
     * Get the value of calculatedMonthlyRate
     *
     * @return the value of calculatedMonthlyRate
     */
    public double getCalculatedMonthlyRate() {
        calculatedMonthlyRate = (Math.pow(Math.pow((1.0 + interestRate/200.0), 2.0), 1.0/12.0) - 1.0) * 100;
        return calculatedMonthlyRate;
    }

    

    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    

    /**
     * Get the value of amortizationPeriod
     *
     * @return the value of amortizationPeriod
     */
    public double getAmortizationPeriod() {
        return amortizationPeriod;
    }

    /**
     * Set the value of amortizationPeriod
     *
     * @param amortizationPeriod new value of amortizationPeriod
     */
    public void setAmortizationPeriod(double amortizationPeriod) {
        this.amortizationPeriod = amortizationPeriod;
    }

    

    /**
     * Get the value of interestRate
     *
     * @return the value of interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Set the value of interestRate
     *
     * @param interestRate new value of interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }    
}
