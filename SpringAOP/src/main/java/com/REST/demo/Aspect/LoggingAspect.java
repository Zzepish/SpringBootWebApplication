package com.REST.demo.Aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * LoggingAspect - Aspect
     * @Before/@After etc. - Advice
     * Execution expression - point-cut (we can combine expressions via "||")
     */
    // return type, class-name.method-name(args)
    @Before("execution(* com.REST.demo.Service.JobService.*(..))")
    public void logMethodBeforeCall(JoinPoint jp)
    {
        this.logger.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.REST.demo.Service.JobService.*(..))")
    public void logMethodAfterCall(JoinPoint jp)
    {
        this.logger.info("Method call ended: " + jp.getSignature().getName());
    }
}
