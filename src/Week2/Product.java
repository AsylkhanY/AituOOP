package Week2;

public class Product {
    private int id;
    private String name;
    private boolean inStock;
    private int price;


    public Product(int id, String name, boolean inStock, int price){
        this.id = id;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public boolean isInStock(){return inStock;}

    public void setInStock(boolean inStock){this.inStock = inStock;}

    public int getPrice(){return price;}

    public void setPrice(int price){this.price = price;}

    public float getPriceAfterDiscount(int discountPercent){
        return price - getDiscountAmount(discountPercent);
    }

    public float getDiscountAmount(int discountPercent){
        return price * discountPercent / 100;
    }

    @Override
    public String toString(){
        return "ID:" + id + " Name:" + name + " In stock:" + inStock + " Price:" + price;
    }
}
