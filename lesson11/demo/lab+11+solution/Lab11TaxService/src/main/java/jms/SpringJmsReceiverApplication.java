package jms;

import jakarta.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
@EnableJms
public class SpringJmsReceiverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsReceiverApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Receiver has started ...");
	}
}



