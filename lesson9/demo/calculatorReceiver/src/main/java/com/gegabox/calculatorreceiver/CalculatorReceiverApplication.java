package com.gegabox.calculatorreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class CalculatorReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorReceiverApplication.class, args);
	}

}
