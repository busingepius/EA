package bank.integration.email;

import bank.aop.DaoLoggingAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private Logger logger = LoggerFactory.getLogger(EmailSender.class);

    public void sendEmail(String message){
        logger.debug("Sending email message: "+message);
        System.out.println(message);
    }
}
