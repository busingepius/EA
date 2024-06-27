package products;

public class Supplier {
    private int supplierId;
    private String name;
    private String phone;

    public Supplier(int supplierId, String name, String phone) {
        this.supplierId = supplierId;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
