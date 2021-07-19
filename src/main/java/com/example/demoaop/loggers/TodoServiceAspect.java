package com.example.demoaop.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TodoServiceAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demoaop.services.TodosServiceImpl.*(..))")
    public void beforeReturn(JoinPoint inputValue) {
        logger.info("Parameter input was {}",  inputValue.getArgs());
    }

    @AfterReturning(value = "execution(* com.example.demoaop.services.TodosServiceImpl.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }
}
