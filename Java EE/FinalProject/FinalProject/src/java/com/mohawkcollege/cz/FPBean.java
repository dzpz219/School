/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohawkcollege.cz;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.BarChart;
import com.googlecode.charts4j.BarChartPlot;
import static com.googlecode.charts4j.Color.ALICEBLUE;
import static com.googlecode.charts4j.Color.BLACK;
import static com.googlecode.charts4j.Color.BLUEVIOLET;
import static com.googlecode.charts4j.Color.LAVENDER;
import static com.googlecode.charts4j.Color.WHITE;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.DataUtil;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.Plots;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Danny
 */
@ManagedBean(name = "fpBean")
@SessionScoped

public class FPBean implements Serializable{
    @PersistenceContext(unitName = "FinalProjectPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of FPBean
     */
    public FPBean() {}
    
    private String meterID;

    /**
     * Get the value of meterID
     *
     * @return the value of meterID
     */
    public String getMeterID() {
        return meterID;
    }

    /**
     * Set the value of meterID
     *
     * @param meterID new value of meterID
     */
    public void setMeterID(String meterID) {
        this.meterID = meterID;
    }
    
    private List<Readings> readingDetails;

    /**
     * Get the value of readingDetails
     *
     * @return the value of readingDetails
     */
    public List<Readings> getReadingDetails() {
        return readingDetails;
    }

    /**
     * Set the value of readingDetails
     *
     * @param readingDetails new value of readingDetails
     */
    public void setReadingDetails(List<Readings> readingDetails) {
        this.readingDetails = readingDetails;
    }
            
    private Costs cost;

    /**
     * Get the value of cost
     *
     * @return the value of cost
     */
    public Costs getCost() {
        return cost;
    }

    /**
     * Set the value of cost
     *
     * @param cost new value of cost
     */
    public void setCost(Costs cost) {
        this.cost = cost;
    }
    
    public String setMeter(Meters m){
        meterID = m.getMeterId();
        readingDetails = (em.createNamedQuery("Readings.findByMeterID").setParameter("meterId", meterID)).getResultList();
        calculateCosts(meterID);
        return "summary";
    }
    
    public String billSummary(Readings r){
        cost = r.getCosts();
        return "billdetails";
    }
    
    public List<Meters> getMeters(){
        return (em.createNamedQuery("Meters.findAll")).getResultList();
    }
    
    public List<Readings> getReadings(String id){
        readingDetails = (em.createNamedQuery("Readings.findByMeterID").setParameter("meterId", id)).getResultList();
        calculateCosts(id);
        return readingDetails;
    }
    
    public void calculateCosts(String id){
            meterID = id;
            Calendar calendar = new GregorianCalendar();
        
        if ((em.createNamedQuery("Costs.findByMeterId").setParameter("meterId", meterID)).getResultList().isEmpty()){
            for (Readings r : readingDetails){
                calendar.set(Calendar.MONTH, Integer.valueOf(r.getReadingDate().substring(5, 7)));
                double daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                
                Costs c = new Costs();
                double amount;
                double low = 0;
                double lowCost = 0;
                double medium = 0;
                double mediumCost = 0;
                double high = 0;
                double highCost = 0;
                double avg = 0;
                double adminfee = 15.00;
                double subtotal;
                double tax;
                double total;

                if (readingDetails.indexOf(r) == 0){
                    amount = (Double.valueOf(r.getReading()) / 50.0);
                }      
                else{
                    Readings prev = readingDetails.get(readingDetails.indexOf(r) - 1);
                    amount = ((Double.valueOf(r.getReading()) - Integer.valueOf(prev.getReading())) / 50.0);
                }
                if (amount <= 5.0){
                  low = amount;
                  medium = 0;
                  high = 0;
                }
                else if (amount > 5.0 && amount <= 25.0){
                    low = 5.0;
                    medium = amount - low;
                    high = 0;
                }
                else if (amount > 25.0){
                    low = 5.0;
                    medium = 20.0;
                    high = amount - medium - low;             
                }
                avg = (amount * 1000.0)/daysOfMonth;
                lowCost = low * 0.50;
                mediumCost = medium * 0.55;
                highCost = high * 0.60;
                subtotal = (low * 0.50) + (medium * 0.55) + (high * 0.60) + adminfee;
                tax = subtotal * 0.13;
                total = subtotal + tax;
                
                c.setMeterId(meterID);
                c.setReadingDate(r.getReadingDate());
                c.setAmount(amount);
                c.setLow(low);
                c.setLowAmount(lowCost);
                c.setMedium(medium);
                c.setMediumAmount(mediumCost);
                c.setHigh(high);
                c.setHighAmount(highCost);
                c.setAverage(avg);
                c.setAdminfee(adminfee);
                c.setSubtotal(subtotal);
                c.setTax(tax);
                c.setTotal(total);
                persist(c);
                r.setAmount(amount);
                r.setTotal(total);
                r.setCosts(c);
                merge(r);
            }
        } 
    }
    
    public String createGraph() {
        // Defining data plots.
        List<Double> amountList = new ArrayList<Double>();
        List<Double> sortList = new ArrayList<Double>();
        List<String> dateList = new ArrayList<String>();
        Calendar calendar = new GregorianCalendar();
        
        for (Readings r : readingDetails){
                amountList.add(r.getTotal());
                sortList.add(r.getTotal());
                calendar.set(Calendar.MONTH, Integer.valueOf(r.getReadingDate().substring(5, 7) ) - 1);
                dateList.add(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()).substring(0, 3));
        }
        
        Collections.sort(sortList);
        Double maxValue = sortList.get(amountList.size() - 1) * 1.25;
        Data chartData= DataUtil.scaleWithinRange(0, maxValue, amountList);
        BarChartPlot amount = Plots.newBarChartPlot(chartData,BLUEVIOLET, "Monthly Bill");
        
        // Instantiating chart.
        BarChart chart = GCharts.newBarChart(amount);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels dollars = AxisLabelsFactory.newAxisLabels("$", 50.0);
        dollars.setAxisStyle(axisStyle);
        AxisLabels date = AxisLabelsFactory.newAxisLabels("Date", 50.0);
        date.setAxisStyle(axisStyle);

        // Adding axis info to chart.
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(dateList));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, maxValue));
        chart.addYAxisLabels(dollars);
        chart.addXAxisLabels(date);

        chart.setSize(1000, 300);
        chart.setBarWidth(BarChart.AUTO_RESIZE);
        chart.setTitle("Bill Summary Chart", BLACK, 16);
        chart.setGrid(100, 10, 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(ALICEBLUE));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, LAVENDER, 100);
        fill.addColorAndOffset(WHITE, 0);
        chart.setAreaFill(fill);
        return chart.toURLString();
    }
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public void merge(Object object) {
        try {
            utx.begin();
            em.merge(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
