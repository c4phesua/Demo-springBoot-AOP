package com.example.demoaop.loggers;

import com.example.demoaop.exceptions.BadRequestException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TodoServiceAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.demoaop.services.TodosService.*(..))")
    public void beforeReturn(JoinPoint inputValue) {
        logger.info("Parameter input was {}",  inputValue.getArgs());
    }

    @Around("@annotation(com.example.demoaop.services.HandleException)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        }
        catch (JpaSystemException jpaSystemException){
            jpaSystemException.printStackTrace();
            throw new BadRequestException("Check todo id and status " +
                    "status must be open or closed. " +
                    "ID must be unique, change another id and try again. Addition info: "
            + jpaSystemException.getMessage());
        }
        catch (Exception exception){
            throw new BadRequestException(exception.getMessage());
        }
        finally {
            long timeTaken = System.currentTimeMillis() - startTime;
            logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        }
    }

    @AfterReturning(value = "execution(* com.example.demoaop.services.TodosService.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }


}
