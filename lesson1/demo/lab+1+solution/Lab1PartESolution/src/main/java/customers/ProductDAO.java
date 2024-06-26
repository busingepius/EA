package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
    @Autowired
    private ILogger logger ;
    public void save(Product product){
        System.out.println("Saving product");
        logger.log("Product is saved in the DB: "+ product.getName() );
    }
}
