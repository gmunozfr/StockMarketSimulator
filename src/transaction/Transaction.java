package transaction;

// Author: Gamaliel Munoz Fraginals/2017092



public class Transaction{

    // Here I am specifying the attributes for the transaction to be required
    private int t_id;
    private int inv_id;
    private int c_id;
    private double t_price;

    // The following is defining the private transaction constructor
    private Transaction(int t_id, int inv_id, int c_id, double t_price){
        this.t_id = t_id;
        this.inv_id = inv_id;
        this.c_id = c_id;
        this.t_price = t_price;

    }

    // Setting up getters and setters in order to be able to either access
    // values or modify them!
    public int getTid(){
        return t_id;
    }

    public void setTid(int t_id){
        this.t_id = t_id;
    }

    public int getInv_id(){
        return inv_id;
    }

    public void setInv_id(int inv_id){
        this.inv_id = inv_id;
    }

    public int getCid(){
        return c_id;
    }

    public void setCid(int c_id){
        this.c_id = c_id;
    }

    public double getTPrice(){
        return t_price;
    }

    public void setTPrice(double t_price){
        this.t_price = t_price;
    }

    // Method which will allow us to print the values regarding objects
    @Override
    public String toString(){
        return "Transaction Id: " + t_id + " Investor Id: " + inv_id + " Company Id: " + c_id +
                " Transaction price: " + t_price;
    }

    // Builder Pattern. Generating a nested static Transaction builder class!!
    public static class TransactionBuilder{
        private int t_id;
        private int inv_id;
        private int c_id;
        private double t_price;

        //The following is the constructor that is being created for the inner class!
        public TransactionBuilder(int t_id, int inv_id, int c_id, double t_price){
            this.t_id = t_id;
            this.inv_id = inv_id;
            this.c_id = c_id;
            this.t_price = t_price;
        }

        // This method will allow to create the object transferring the values to the outer class!
        public Transaction build(){
            return new Transaction(t_id, inv_id, c_id, t_price);
        }
     }
 }

