package bank.aop;

import bank.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class genericAOP {
    @Autowired
    private Logger logger;

    @Before("execution(* bank.dao.AccountDAO.*(..))")
    public void before() {
        logger.log("AOP Logging in the bank.dao package");
    }

    @Around("execution(* bank.service.AccountService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            StopWatch stopWatch = new StopWatch();
            logger.log(stopWatch.getLastTaskTimeMillis() + "ms");
            stopWatch.stop();
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Before("execution(* bank.jms.JMSSender.*(..))")
    public void beforeJMS() {
        logger.log("AOP Logging in the bank.jms package");
    }
}
