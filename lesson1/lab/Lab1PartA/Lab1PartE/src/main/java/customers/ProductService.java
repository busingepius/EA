package customers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    private IProductDAO productDAO;
    private IEmailSender emailSender;

    public ProductService(
            IProductDAO productDAO,
            IEmailSender emailSender
    ) {
        this.productDAO = productDAO;
        this.emailSender = emailSender;
    }

    public void addProduct(
            String name,
            double price,
            int quantity,
            String email
    ) {
        Product product = new Product(name, price, quantity);
        productDAO.save(product);
        emailSender.sendEmail(email, "Product added");
    }
}
