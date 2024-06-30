package com.gegabox.lab2part2.customers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public class CustomerDAOMock implements ICustomerDAO {
    private ILogger logger;

    public CustomerDAOMock(ILogger logger) {
        this.logger = logger;
    }


    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MockCustomerDAO: saving customer " + customer.getName());
        logger.log("Customer is saved in the DB: " + customer.getName());
    }
}

