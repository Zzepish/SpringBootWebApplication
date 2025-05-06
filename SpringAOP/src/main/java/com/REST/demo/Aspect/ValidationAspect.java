package com.REST.demo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    /**
     * In this particular scenario - we can retrieve arguments of the called methods, and pass them to Aspect method.
     * We can also change method arguments
     */
    @Around("execution(* com.REST.demo.Service.JobService.find(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int id) throws Throwable
    {
        this.logger.info("Requested ID: " + id);

        if (id < 0) {
            id = Math.abs(id);
            this.logger.info("Changing ID to: " + id);
        }

        //Here we are replacing original arguments
        return jp.proceed(new Object[]{id});
    }
}
