package com.gegabox.lab2part2.customers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CustomerService implements ICustomerService {
    ICustomerDAO customerDAO;
    IEmailSender emailSender;

    public CustomerService(
            ICustomerDAO customerDAO,
            IEmailSender emailSender
    ) {
        this.customerDAO = customerDAO;
        this.emailSender = emailSender;
    }


    public void addCustomer(
            String name,
            String email,
            String street,
            String city,
            String zip
    ) {
        Customer customer = new Customer(name, email);
        Address address = new Address(street, city, zip);
        customer.setAddress(address);
        customerDAO.save(customer);
        emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
    }

}
