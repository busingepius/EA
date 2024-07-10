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
public class DaoLoggingAdvice {
	private Logger logger = LoggerFactory.getLogger(DaoLoggingAdvice.class);

	@After("execution(* bank.dao.*.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.info("Call was made to:" + joinpoint.getSignature().getName()
				+ " on " + joinpoint.getTarget().getClass());
	}
}
