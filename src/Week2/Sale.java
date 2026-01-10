package Week2;

public class Sale {
    private int id;
    private Product[] products;
    private String customerName;
    private int bonus;
    private boolean bonusAdded;
    private int cost;

    public Sale(int id, Product[] products, String customerName){
        setId(id);
        setProducts(products);
        setCustomerName(customerName);
        calculateCost(); // Calculate cost immediately upon creation
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public Product[] getProducts(){return products;}
    public void setProducts(Product[] products){this.products = products;}

    public String getCustomerName(){return customerName;}
    public void setCustomerName(String customerName){
        if(customerName != null && !customerName.isEmpty()) {
            this.customerName = customerName;
        } else {
            this.customerName = "Unknown Customer";
        }
    }

    public int getCost(){
        return calculateCost();
    }

    public int calculateCost(){
        int priceSum = 0;
        if (products != null) {
            for (Product product : products){
                if (product != null) {
                    priceSum += product.getPrice();
                }
            }
        }
        this.cost = priceSum;
        return cost;
    }

    @Override
    public String toString(){
        StringBuilder productList = new StringBuilder();
        if (products != null) {
            for(Product p : products){
                if(p != null) productList.append("\n   - ").append(p.getName()).append(" (").append(p.getPrice()).append(" KZT)");
            }
        }
        return "Sale ID: " + id + "\nCustomer: " + customerName + "\nProducts Purchased:" + productList.toString() + "\nTotal Cost: " + getCost();
    }
}