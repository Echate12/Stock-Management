package ma.professional.kitchen.professional_kitchen.dto;

public class CategorySummary {
    private String category;
    private long totalProducts; // Number of rows/products in the category
    private int totalQuantity; // Total quantity of all products in the category
    private double totalPurchasePrice; // Total purchase price of all products in the category
    private double totalSalePrice; // Total sale price of all products in the category

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public void setTotalPurchasePrice(double totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public double getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(double totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }
}
