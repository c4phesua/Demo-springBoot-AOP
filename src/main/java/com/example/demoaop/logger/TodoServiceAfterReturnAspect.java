package com.example.demoaop.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TodoServiceAfterReturnAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demoaop.service.TodosServiceImpl.*(..))")
    public void beforeReturn(JoinPoint returnValue) throws Throwable {
        logger.info("Parameter input was {}",  returnValue.getArgs());
    }

    @AfterReturning(value = "execution(* com.example.demoaop.service.TodosServiceImpl.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }
}
