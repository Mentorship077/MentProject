package axcontrol.model;

public class Product {
    private String productTitle;
    private String productDescription;

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }

    public Product(String productTitle, String productDescription) {
        this.productTitle = productTitle;
        this.productDescription = productDescription;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
