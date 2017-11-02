package lab2;

/**
 *
 * @author Chao
 */
public class VendingMachine {
            private String product1;
            private String product2;
            private Double price1;
            private Double price2;
            private int quantity1;
            private int quantity2;
            private Double credit = 0.00;
            private Double total = 0.00;

            /**
             *  VendingMachine constructor
             * @param product1 First product of vending machine
             * @param product2 Second product of vending machine
             * @param price1 Price of first product
             * @param price2 Price of second product
             * @param quantity1 Stock of first product
             * @param quantity2 Stock of second product
             */
            public VendingMachine(String product1, String product2, Double price1, Double price2, int quantity1, int quantity2){
                this.product1 = product1;
                this.product2 = product2;
                this.price1 = price1;
                this.price2 = price2;
                this.quantity1 = quantity1;
                this.quantity2 = quantity2;
            }
            
            /**
             * 
             */
            public void insertToonie(){
                this.credit += 2.00;
            }
            
            /**
             * 
             */
            public void insertLoonie(){
                this.credit += 1.00;
            }
            
             /**
             * 
             */
            public void insertQuarter(){
            this.credit += 0.25;
            }
            
             /**
             * 
             */
            public void insertDime(){
                this.credit += 0.10;
            }
            
             /**
             * 
             */
            public void insertNickel(){
                this.credit += 0.05;
            }
            
            /**
             * 
             * @return Double, returns the current credit in vending machine
             */
            public Double coinReturn(){
                Double amt = credit;
                this.credit = 0.00;
                return amt;
            }
            
            /**
             * 
             * @param productNumber
             * @return true or false based on success of vend product
             */
            public boolean vend(int productNumber){
                boolean validProduct = ((productNumber == 1 && quantity1 > 0) || (productNumber == 2 && quantity2 > 0));
                boolean validPrice;
                switch (productNumber){
                    case 1:
                        validPrice = (this.credit >= price1);
                        break;
                    case 2:
                        validPrice = (this.credit >= price2);
                        break;
                    default:
                        return false;
                }
                
                if (validProduct && validPrice){
                    total += credit;
                    credit = 0.00;
                    if (productNumber == 1){
                        quantity1 --;
                    }
                    else {
                        quantity2 --;
                    }
                        return true;
                }
                else {
                    return false;
                }
            }
            
            /**
             * 
             * @return Double, total of credits
             */
            public Double getTotal(){
                return total;
            }
            
            /**
             * 
             * @return Double, current credits
             */
            public Double getCredit(){
                return credit;
            }
            
            /**
             * 
             * @return String, returns product1
             */
            public String getProduct1(){
                return product1;
            }
            
            /**
             * 
             * @return String, returns product2
             */
            public String getProduct2(){
                return product2;
            }
            
            /**
             * 
             * @param q1, quantity of product1
             * @param q2, quantity of product2
             */
            public void restock(int q1, int q2){
                quantity1 += q1;
                quantity2 += q2;
            }
            
            /**
             * 
             * @return String, summary of vending machine info
             */
            @Override
            public String toString(){
                return String.format("Product 1: %1s, Price: $%.2f, Quantity: %d\nProduct 2: %4s, Price: $%.2f, Quantity: %d\nCredit: %.2f, Total: %.2f", product1, price1, quantity1, product2, price2, quantity2, credit, total);
            }
}
