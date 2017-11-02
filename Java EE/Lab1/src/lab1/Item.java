package lab1;

/**
 *
 * @author Danny
 */
public class Item {
    private String name;
    private Double price;
    
    public Item (String n, Double p){
        name = n;
        price = p;
    }
    
    public String getName(){
        return name;
    }
    
    public Double getPrice(){
        return price;
    }
}
