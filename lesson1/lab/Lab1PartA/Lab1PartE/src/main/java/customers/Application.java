package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

// dependency injection using Java configuration + classpath scanning + auto-wiring
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ICustomerService customerService = context.getBean("customerService", ICustomerService.class);
        IProductService productService = context.getBean("productService", IProductService.class);

        customerService.addCustomer(
                "Frank Brown",
                "fbrown@acme.com",
                "mainstreet 5",
                "Chicago",
                "60613"
        );

        productService.addProduct(
                "Notebook",
                12.5,
                100,
                "a@gmail.com"
        );
    }
}

