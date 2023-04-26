package com.example.realTemp.aop;

import com.example.realTemp.restController.DriverRestController;
import com.example.realTemp.service.DriverServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DriverServiceImplAspect {

    Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);
    @Before(value="execution(* com.example.realTemp.service.DriverServiceImpl..*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info(" (Before) In method : " + joinPoint.getSignature().getName());
    }

    @After(value="execution(* com.example.realTemp.service.DriverServiceImpl..*(..))")
    public void AfterAdvice(JoinPoint joinPoint){
        logger.info(" (After) In method :" + joinPoint.getSignature().getName());
    }

}
