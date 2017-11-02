/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohawkcollege.cz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Danny
 */
@ManagedBean
@Named(value = "payment")
@RequestScoped

public class Payment {
    
    public Payment() {
    }
    
    public Payment(Calendar date, double balance, double interest, double principle, double payment) {
        this.date = date;
        this.balance = balance;
        this.interest = interest;
        this.principle = principle;
        this.payment = payment;
    }
    
    private Calendar date = new GregorianCalendar();

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy");
        date.add(Calendar.MONTH, 1);
        date.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(date.getTime());
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    private double balance;

    /**
     * Get the value of balance
     *
     * @return the value of balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the value of balance
     *
     * @param balance new value of balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double interest;

    /**
     * Get the value of interest
     *
     * @return the value of interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * Set the value of interest
     *
     * @param interest new value of interest
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    private double principle;

    /**
     * Get the value of principle
     *
     * @return the value of principle
     */
    public double getPrinciple() {
        return principle;
    }

    /**
     * Set the value of principle
     *
     * @param principle new value of principle
     */
    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    private double payment;

    /**
     * Get the value of payment
     *
     * @return the value of payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Set the value of payment
     *
     * @param payment new value of payment
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

}
