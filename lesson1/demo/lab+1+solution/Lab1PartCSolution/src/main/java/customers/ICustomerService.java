package customers;

public interface ICustomerService {
	void addCustomer(String name, String email, String street,String city, String zip);

	void setCustomerDAO(ICustomerDAO customerDAO);

	void setEmailSender(IEmailSender emailSender);
}
