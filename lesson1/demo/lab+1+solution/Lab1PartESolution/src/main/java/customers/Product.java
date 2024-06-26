package customers;

public class Product {
    private int productNumber;
    private String name;

    public Product(int productNumber, String name) {
        this.productNumber = productNumber;
        this.name = name;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
