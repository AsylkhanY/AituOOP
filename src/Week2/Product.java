package Week2;

public class Product {
    private int id;
    private String name;
    private boolean inStock;
    private int price;

    public Product(int id, String name, boolean inStock, int price){
        setId(id);
        setName(name);
        setInStock(inStock);
        setPrice(price);
    }

    public Product() {
        this(0, "Empty Product", false, 0);
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){
        if(name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public boolean isInStock(){return inStock;}
    public void setInStock(boolean inStock){this.inStock = inStock;}

    public int getPrice(){return price;}
    public void setPrice(int price){
        if(price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    @Override
    public String toString(){
        return "ID: " + id + " | Name: " + name + " | In Stock: " + inStock + " | Price: " + price;
    }
}