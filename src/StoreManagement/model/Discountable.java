package StoreManagement.model;

public interface Discountable {
    double getDiscountedPrice(double percentage);
    String getPromotionDetails();
}