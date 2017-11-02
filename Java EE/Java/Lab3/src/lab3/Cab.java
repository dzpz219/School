package lab3;

/**
 *
 * @author Chao
 */
public class Cab {
    private static  Double companyTotalFare = 0.0;
    private Double rate;
    private Double taxiTotalFare = 0.0;
    private int tripCounter = 0;
    private int cabID;
    
    /**
     * 
     * @param cabID 
     */
    public Cab(int cabID){
        this.cabID = cabID;
    }
    
    /**
     * 
     * @param rider
     * @return passenger information
     */
    public String pickUp(Passenger rider){
        String front = rider.isInFrontSeat() ? "Passenger in front. " : "";
        if (rider.isInFrontSeat()){
            front += rider.getWeight() >= 40 ? "Airbag is on." : "";
        }
        tripCounter ++;
        return "Cab ID: " + cabID + ", Trip number: " + tripCounter + " " + front;
    }
    
    /**
     * 
     * @param minutes
     * @return 
     */
    public boolean dropOff(int minutes){
        taxiTotalFare += minutes * rate;
        return true;
    }
    
    public void endOfShift(){
        companyTotalFare += taxiTotalFare;
    }
    
    /**
     * 
     * @return formatted string of the cab information
     */
    public String report(){
        return String.format("Cab %d had %d trips and earned $%.2f (%.1f%% of today's total)", cabID, tripCounter, taxiTotalFare, (taxiTotalFare/companyTotalFare)*100);
    }
    
    public Double getRate(){
        return rate;
    }
    
    public void setRate(Double rate){
        this.rate = rate;
    }
    
    public int getID(){
        return cabID;
    }
}
