package bank.integration.jms;

import bank.integration.email.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender{
	@Autowired
	JmsTemplate jmsTemplate;

	private Logger logger = LoggerFactory.getLogger(JMSSender.class);

	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
		logger.debug("JMSSender: sending JMS message ="+text);
		jmsTemplate.convertAndSend("taxQueue",text);
	}

}
