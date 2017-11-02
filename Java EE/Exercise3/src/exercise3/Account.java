package exercise3;

/**
 * @author Danny
 */
public class Account {
    private String name;
    private Double balance;
    
    // account constructor
    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    // set name to input value n
    public void setName(String n){
        name = n;
    }
    
    // name getter
    public String getName(){
        return name;
    }
    
    // balance getter
    public Double getBalance(){
        return balance;
    }
    
    // add onto current balance with depositamount
    // output error message for values under 0
    public void deposit(Double depositAmount){
        if (depositAmount < 0){
            System.out.println("Invalid deposit amount");
        }
        else {
            balance += depositAmount;
        }
    }
    // subtract  current balance with depositamount
    // output error message for values under 0
    public void withdraw(Double withdrawAmount){
        if (withdrawAmount < 0){
            System.out.println("Invalid withdraw amount");
        }
        else{
            balance -= withdrawAmount;
        }
    }
}
