package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    EmailSender emailSender;

    public void addProduct(Product product){
        productDAO.save(product);
        emailSender.sendEmail("john@gmail.com", "Product is added");
    }

}
