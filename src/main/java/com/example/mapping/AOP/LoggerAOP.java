package com.example.mapping.AOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggerAOP {

    @Before("within(@org.springframework.stereotype.Service *)")
    public void loggingForService(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Service Method {} called with arguments:", methodName);
        for(Object arg : args){
            log.info("Service Payload: {}", arg);
        }
    }

    @Before("execution(* org.springframework.data.repository.Repository+.*(..))")
    public void loggingForRepository(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Repository Method {} called with arguments:", methodName);

    }

    @Before("within(@org.springframework.web.bind.annotation.RestController *)")
    public void loggingForController(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("RestController Method {} called with arguments:", methodName);
        for(Object arg : args){
            log.info("Controller Payload: {}", arg);
        }
    }
}
