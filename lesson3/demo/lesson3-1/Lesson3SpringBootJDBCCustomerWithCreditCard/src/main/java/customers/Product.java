package customers;

public class Product {

    private int productNumber;
    private String name;
    private double price;
    private Supplier supplier;

    public Product(int productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    // set supplier
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
