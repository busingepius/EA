package com.gegabox.lab2part2;

import com.gegabox.lab2part2.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab2Part2Application implements CommandLineRunner {
    private CustomerService customerService;

    public  Lab2Part2Application(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab2Part2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.addCustomer(
                "Frank Brown",
                "fbrown@acme.com",
                "mainstreet 5",
                "Chicago",
                "60613"
        );
    }
}
