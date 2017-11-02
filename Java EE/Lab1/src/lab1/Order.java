package lab1;

/**
 *
 * @author Danny
 */
public class Order {
    private Item item;
    private Integer amount;
    
    public Order (Item i, Integer a){
        item = i;
        amount = a;
    }
    
    public Item getItem(){
        return item;
    }
    
    public Integer getAmount(){
        return amount;
    }
}
