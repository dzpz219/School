/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

/**
 *
 * @author Danny
 */
public class Stock {
    
    public Stock(){}
    
    private String symbol;
    private String name;
    private String last;
    private String change;
    private String percentChange;
    private String colour;
    private String quote;

    /**
     * Get the value of quote
     *
     * @return the value of quote
     */
    public String getQuote() {
        return quote;
    }

    /**
     * Set the value of quote
     *
     * @param quote new value of quote
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    /**
     * Get the value of colour
     *
     * @return the value of colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Set the value of colour
     *
     * @param colour new value of colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Get the value of percentChange
     *
     * @return the value of percentChange
     */
    public String getPercentChange() {
        return percentChange;
    }

    /**
     * Set the value of percentChange
     *
     * @param percentChange new value of percentChange
     */
    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }


    /**
     * Get the value of change
     *
     * @return the value of change
     */
    public String getChange() {
        return change;
    }

    /**
     * Set the value of change
     *
     * @param change new value of change
     */
    public void setChange(String change) {
        this.change = change;
    }


    /**
     * Get the value of last
     *
     * @return the value of last
     */
    public String getLast() {
        return last;
    }

    /**
     * Set the value of last
     *
     * @param last new value of last
     */
    public void setLast(String last) {
        this.last = last;
    }


    /**
     * Get the value of Name
     *
     * @return the value of Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of Name
     *
     * @param Name new value of Name
     */
    public void setName(String Name) {
        this.name = Name;
    }


    /**
     * Get the value of symbol
     *
     * @return the value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set the value of symbol
     *
     * @param symbol new value of symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
