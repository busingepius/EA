package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Logger logger() {
		return new Logger();
	}
	
	@Bean
	public ICustomerDAO customerDAO() {
		ICustomerDAO customerDAO = new CustomerDAO();
		customerDAO.setLogger(logger());
		return customerDAO;
	}
	
	@Bean
	public ICustomerService customerService() {
		ICustomerService customerService = new CustomerService();
		customerService.setCustomerDAO(customerDAO());
		customerService.setEmailSender(emailSender());
		return customerService;
	}
	
	@Bean
	public IEmailSender emailSender() {
		IEmailSender emailSender = new EmailSender();
		emailSender.setLogger(logger());
		return emailSender;
	}

}
