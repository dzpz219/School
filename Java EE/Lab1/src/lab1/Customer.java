package lab1;

/**
 *
 * @author Danny
 */
public class Customer {
    
    private String Name;
    private String Number;
    private String Postal;
    
    public Customer(String name, String number, String postal){
        Name = name;
        Number = number;
        Postal = postal;
    }
    
    public String getName(){
        return Name;
    }
    
    public String getNumber(){
        return Number;
    }
    
    public String getPostal(){
        return Postal;
    }
}
