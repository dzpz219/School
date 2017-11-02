package lab3;

/**
 *
 * @author Chao
 */
public class Passenger {
    private Double weight;
    private boolean inFrontSeat;
    
    public Passenger(Double weight, boolean front){
        this.weight = weight;
        this.inFrontSeat = front;
    }
    
    public Double getWeight(){
        return weight;
    }
    
    public boolean isInFrontSeat(){
        return inFrontSeat;
    }
}
