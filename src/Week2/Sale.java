package Week2;

import java.sql.Array;

public class Sale {
    private int id;
    private Product[] products;
    private String customerName;
    private int bonus;

    private boolean bonusAdded;
    private int cost;

    public Sale(int id, Product[] products, String customerName){
        this.id = id;
        this.products = products;
        this.customerName = customerName;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public Product[] getProducts(){return products;}

    public void setProducts(Product[] products){this.products = products;}

    public String getCustomerName(){return customerName;}

    public void setCustomerName(String customerName){
        if(!customerName.isEmpty()) {
            this.customerName = customerName;
        }
        else{
            System.out.println("Warning! Name can not be empty");
        }
    }

    public int getBonus(){return bonus;}

    public void setBonus(int bonus){
        if(bonus >= 0) {
            this.bonus = bonus;
        }
        else{
            System.out.println("Warning! Bonus can not be negative");
        }
    }

    public int getCost(){
        if(cost == 0) {
           return calculateCost();
        }
        else{
            return cost;
        }
    }
    public int calculateCost(){
        int priceSum = 0;
        for (Product product : products){
            priceSum += product.getPrice();
        }
        return cost = priceSum;
    }

    public void addBonus(double bonusRate) {
        if (bonusAdded) {
            return;
        }
        if(bonusRate < 0){
            System.out.println("Warning! Bonus rate can not be negative");
            return;
        }
        bonus += getCost() * bonusRate / 100;
        bonusAdded = true;
    }

    @Override
    public String toString(){
        String output = "ID:" + id + "Products:{";
        for(Product product : products){
            output += "\n" + product.toString();
        }
        output += "}\nCustomer's name:" + customerName + " Cost:" + getCost();
        return output;
    }
}
