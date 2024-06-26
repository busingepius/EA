package customers;

public interface ICustomerDAO {
	void save(Customer customer) ;

	void setLogger(ILogger logger);
}
