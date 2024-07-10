package bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JmsLoggingAdvice {
	private Logger logger = LoggerFactory.getLogger(DaoLoggingAdvice.class);
	
	@After("execution(* bank.integration.jms.JMSSender.sendJMSMessage(..)) && args (message))")
	public void log(JoinPoint joinpoint, String message) {
		logger.info("JMS Message: "+message);
	}

}
