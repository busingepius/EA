package customers;

public class CustomerDAO implements ICustomerDAO{
//	private ILogger logger = new Logger();

//	constructor injection note the name is the same as the id
	private ILogger logger;

	public CustomerDAO(ILogger logger) {
		this.logger = logger;
	}

	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

//	public void setLogger(Logger logger) {
//	}
}
