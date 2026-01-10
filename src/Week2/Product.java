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

    public Product() {
        this.id = 0;
        this.name = "Empty Product";
        this.inStock = false;
        this.price = 0;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){
        if(!name.isEmpty()) {
            this.name = name;
        }
        else{
            System.out.println("Warning! Name can not be empty");
        }
    }

    public boolean isInStock(){return inStock;}

    public void setInStock(boolean inStock){this.inStock = inStock;}

    public int getPrice(){return price;}

    public void setPrice(int price){
        if(price > 0) {
            this.price = price;
        }
        else{
            System.out.println("Warning! Price can not be negative or zero");
        }
    }

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
