package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class SpringJmsCalcSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;


	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJmsCalcSenderApplication.class, args);
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {
		CalcInstruction cinst = new CalcInstruction('+',5);
		ObjectMapper objectMapper = new ObjectMapper();
		String cinstAsString = objectMapper.writeValueAsString(cinst);

		System.out.println("Sending a JMS message:" + cinstAsString);
		jmsTemplate.convertAndSend("testQueue",cinstAsString);

		CalcInstruction cinst2 = new CalcInstruction('-',2);
		String cinst2AsString = objectMapper.writeValueAsString(cinst2);

		System.out.println("Sending a JMS message:" + cinst2AsString);
		jmsTemplate.convertAndSend("testQueue",cinst2AsString);

		CalcInstruction cinst3 = new CalcInstruction('+',3);
		String cinst3AsString = objectMapper.writeValueAsString(cinst3);

		System.out.println("Sending a JMS message:" + cinst3AsString);
		jmsTemplate.convertAndSend("testQueue",cinst3AsString);

	}

}
