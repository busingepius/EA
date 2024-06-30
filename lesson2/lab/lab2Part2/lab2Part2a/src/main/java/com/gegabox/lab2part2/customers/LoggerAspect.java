package com.gegabox.lab2part2.customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class LoggerAspect {
    @After("execution(* com.gegabox.lab2part2.customers.EmailSender.sendEmail(..))")
    public void logAfterAddCustomer(JoinPoint joinPoint) {
        System.out.println( LocalDateTime.now()+" method="+joinPoint.getSignature().getName());
    }
}
