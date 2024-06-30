package com.gegabox.lab2part2.customers;

import org.springframework.stereotype.Service;

@Service
public interface ICustomerDAO {
	void save(Customer customer) ;
}
