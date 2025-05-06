package com.REST.demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.REST.demo.*.*.*(..))")
    public Object logTime(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();

        //We need to call this method, to actually run our program, as intended.
        Object obj = jp.proceed();

        long endTime = System.currentTimeMillis();

        this.logger.info(
                "[PERFORMANCE] Time taken to execute '"
                        + jp.getSignature().getDeclaringTypeName()
                        + "."
                        + jp.getSignature().getName()
                        + "()"
                        + "' : " + (endTime - startTime) + "ms"
        );

        // AND we need to return result of our program
        return obj;
    }
}
