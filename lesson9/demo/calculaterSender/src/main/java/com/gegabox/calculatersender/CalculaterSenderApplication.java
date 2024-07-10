package com.gegabox.calculatersender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class CalculaterSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(CalculaterSenderApplication.class, args);
		configurableApplicationContext.close();
	}

	@Override
	public synchronized void run(String... args) throws Exception {
		Calculator calculator = new Calculator("add", 8);
		ObjectMapper objectMapper = new ObjectMapper();
		String calculatorAsString = objectMapper.writeValueAsString(calculator);
		System.out.println("Sending a JMS message:" + calculatorAsString);
		jmsTemplate.convertAndSend("calculator", calculatorAsString);
	}

}
