/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Danny
 */
@ManagedBean
@Named(value = "carBean")
@SessionScoped
public class CarBean implements Serializable {
        
    @PersistenceContext(unitName = "Lab3PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    /**
     * Creates a new instance of CarBean
     */
    public CarBean() {}
    
    private List<Mileage> carMileage;
    private int selectedID;
    private int start;
    private double avgFuel;
    private Cars selectedCar;
    private boolean flag;

    /**
     * Get the value of flag
     *
     * @return the value of flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Set the value of flag
     *
     * @param flag new value of flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    /**
     * Get the value of selectedCar
     *
     * @return the value of selectedCar
     */
    public Cars getSelectedCar() {
        return selectedCar;
    }

    /**
     * Set the value of selectedCar
     *
     * @param selectedCar new value of selectedCar
     */
    public void setSelectedCar(Cars selectedCar) {
        this.selectedCar = selectedCar;
    }

    /**
     * Get the value of avgFuel
     * Check if carMileage list is empty
     * if not, sum up trips and sum up gas
     * @return the value of avgFuel
     */
    public double getAvgFuel() {
        double totalTrip = 0;
        double totalGas = 0;
        while (!carMileage.isEmpty()){
            for (int i = 0; i < carMileage.size(); i++) {
                totalTrip += carMileage.get(i).getTrip();
                totalGas += carMileage.get(i).getGasused();
            }
            return (totalGas/totalTrip) * 100;
        }
        return 0;    
    }

    /**
     * Set the value of avgFuel
     *
     * @param avgFuel new value of avgFuel
     */
    public void setAvgFuel(double avgFuel) {
        this.avgFuel = avgFuel;
    }


    /**
     * Get the value of start
     *
     * @return the value of start
     */
    public int getStart() {
        return start;
    }

    /**
     * Set the value of start
     *
     * @param start new value of start
     */
    public void setStart(int start) {
        this.start = start;
    }
    
    private int end;

    /**
     * Get the value of end
     *
     * @return the value of end
     */
    public int getEnd() {
        return end;
    }

    /**
     * Set the value of end
     *
     * @param end new value of end
     */
    public void setEnd(int end) {
        this.end = end;
    }
    
    private float fuelUsed;

    /**
     * Get the value of fuelUsed
     *
     * @return the value of fuelUsed
     */
    public float getFuelUsed() {
        return fuelUsed;
    }

    /**
     * Set the value of fuelUsed
     *
     * @param fuelUsed new value of fuelUsed
     */
    public void setFuelUsed(float fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    private String year;

    /**
     * Get the value of year
     *
     * @return the value of year
     */
    public String getYear() {
        return year;
    }

    /**
     * Set the value of year
     *
     * @param year new value of year
     */
    public void setYear(String year) {
        this.year = year;
    }

    private String make;

    /**
     * Get the value of make
     *
     * @return the value of make
     */
    public String getMake() {
        return make;
    }

    /**
     * Set the value of make
     *
     * @param make new value of make
     */
    public void setMake(String make) {
        this.make = make;
    }

    private String model;

    /**
     * Get the value of model
     *
     * @return the value of model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Set the value of selected car
     *
     * @param car new value of Cars
     * @return the value of navigation page
     */
    public String setCarID(Cars car){      
        selectedID = car.getId();
        year = car.getModelyear();
        model = car.getModel();
        make = car.getMake();
        return "carDetails";
    }
    
    /**
     * Set the value of new mileage form
     *
     * if there is no mileage history
     * start with 0
     * @return the value of navigation page
     */
    public String setMileage(){
        List<Mileage> list = getCarMileage();
        while (!list.isEmpty()){
            start = list.get(list.size() - 1).getEndkm();
            end = start + 500;
            fuelUsed = 50;
            return "newMileage";
        }
        start = 0;
        end = start + 500;
        fuelUsed = 50;
        return "newMileage";
    }
    
    /**
     * Get the value of selectedID
     *
     * @return the value of selectedID
     */
    public int getSelectedID() {
        return selectedID;
    }

    /**
     * Set the value of selectedID
     *
     * @param selectedID new value of selectedID
     */
    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    /**
     * Get the value of carMileage
     *
     * @return the value of carMileage
     */
    public List<Mileage> getCarMileage() {
        carMileage = (em.createNamedQuery("Mileage.findByCarId")).setParameter("carId", selectedID).getResultList();
        return carMileage;
    }
    
     /**
     * Get the value of all cars
     *
     * @return the value of all cars
     */
    public List<Cars> getCars(){
        List<Cars> allCars = (em.createNamedQuery("Cars.findAll")).getResultList();
        return allCars;
    }
    
    /**
     * add new car object to database
     *
     * create new Cars object and persist to database
     */
    public void addCar(){
        Cars car = new Cars();
        car.setId(selectedID);
        car.setMake(make);
        car.setModel(model);
        car.setModelyear(year);
        persist(car);
    }
    
    /**
     * set the values of car being deleted
     *
     * also toggle delete confirmation with flag
     */
    public void deleteCar(int id, Cars car, boolean flag) {
        selectedID = id;
        selectedCar = car;
        year = car.getModelyear();
        model = car.getModel();
        make = car.getMake();
        this.flag = flag;
    }
    
    /**
     * remove car object from database
     *
     * delete from both Cars and Mileage table
     */
    public void removeCar(){
        try {
           utx.begin();
           em.createNamedQuery("Mileage.deleteMileageByCarId").setParameter("carId", selectedCar).executeUpdate();
           em.createNamedQuery("Cars.deleteById").setParameter("id", selectedID).executeUpdate();
           utx.commit();
           this.flag = !this.flag;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
        
    }
    
    /**
     * add new mileage object to database
     *
     * create new Mileage object and persist to database
     */
    public void addMileage(){
        Cars car = new Cars();
        car.setId(selectedID);
        
        Mileage mileage = new Mileage();
        mileage.setStartkm(start);
        mileage.setEndkm(end);
        mileage.setGasused(fuelUsed);
        mileage.setCarId(car);
        
        persist(mileage);
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
}
