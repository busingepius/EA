package com.gegabox.lab2part2.customers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("production")
class CustomerDAO implements ICustomerDAO{
	private ILogger logger ;

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
}
