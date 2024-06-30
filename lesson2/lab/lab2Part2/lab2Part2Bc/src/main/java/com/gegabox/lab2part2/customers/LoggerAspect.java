package com.gegabox.lab2part2.customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class LoggerAspect {
    @After("execution(* com.gegabox.lab2part2.customers.EmailSender.sendEmail(..)) && args(email, message)")
    public void logAfterAddCustomer(JoinPoint joinPoint, String email, String message) {
        System.out.println(
                LocalDateTime.now()
                        +
                        " method= " + joinPoint.getSignature().getName()
                        +
                        " address= " + email
                        +
                        " message= " + message
                        +
                        " outgoing mail server= "
                        +
                        ((EmailSender) joinPoint.getTarget()).getOutgoingMailServer()

        );
    }
}
