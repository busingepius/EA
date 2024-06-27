package products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductDAO productDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productDao.clearDB();
		Product product = new Product (123, "Iphone 12", 1000.00);
		Supplier supplier = new Supplier(1, "Apple", "53456789965");
		product.setSupplier(supplier);
		productDao.save(product);
		product = new Product (124, "Galaxy S12", 980.00);
		supplier = new Supplier(2, "Samsung", "4433212389965");
		product.setSupplier(supplier);
		productDao.save(product);
		product = new Product (125, "Nokia SX10", 680.00);
		supplier = new Supplier(3, "Ericson", "873456217265");
		product.setSupplier(supplier);
		productDao.save(product);
		System.out.println(productDao.findProductByNumber(123));
		System.out.println(productDao.findProductByNumber(124));
		System.out.println("-----------All products ----------------");
		System.out.println(productDao.getAllProducts());
		System.out.println("-----------Find by product name ----------------");
		System.out.println(productDao.findByProductName("Iphone 12"));
		System.out.println("-----------Remove product ----------------");
		productDao.removeProductByNumber(124);
		System.out.println("-----------All products ----------------");
		System.out.println(productDao.getAllProducts());
	}
}
