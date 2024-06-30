package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// dependency injection using Java configuration
@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService() {
        return new CustomerService(
                new CustomerDAO(logger()),
                new EmailSender(logger())
        );
    }

//    @Bean
//    public CustomerDAO customerDAO() {
//        return new CustomerDAO(logger());
//    }
    @Bean
    public ILogger logger() {
        return new Logger();
    }
//    @Bean
//    public IEmailSender emailSender() {
//        return new EmailSender(new Logger());
//    }


}
