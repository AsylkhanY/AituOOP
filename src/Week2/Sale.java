package Week2;

public class Sale {
    private int id;
    private Product[] products;
    private String customerName;
    private int cost;

    public Sale(int id, Product[] products, String customerName){
        this.id = id;
        this.products = products;
        this.customerName = customerName;
        calculateCost();
    }

    public int calculateCost(){
        int sum = 0;
        if(products != null) {
            for(Product p : products){
                if(p != null) sum += p.getPrice();
            }
        }
        this.cost = sum;
        return cost;
    }

    public int getCost() { return cost; }

    @Override
    public String toString(){
        return "Sale ID: " + id + " | Customer: " + customerName + " | Total: " + cost;
    }
}