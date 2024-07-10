package bank.service;

import bank.domain.AccountChangeEvent;
import bank.integration.email.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventEmailer {
	@Autowired
	EmailSender emailSender;

	private Logger logger = LoggerFactory.getLogger(EventEmailer.class);

	@EventListener
	public void onEvent(AccountChangeEvent event) {
		logger.trace("******** email account change event :" + event);
		emailSender.sendEmail("******** email account change event :" + event);
	}

}
