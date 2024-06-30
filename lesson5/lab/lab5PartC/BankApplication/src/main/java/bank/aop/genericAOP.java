package bank.aop;

import bank.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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
            // stop watch and log time
            long start = System.currentTimeMillis();
            logger.log(start + "ms");
            System.out.println("Time taken to execute the method: " + (System.currentTimeMillis() - start) + "ms");
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
