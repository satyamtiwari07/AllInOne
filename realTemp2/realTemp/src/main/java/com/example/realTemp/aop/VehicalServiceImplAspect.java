package com.example.realTemp.aop;

import com.example.realTemp.restController.VehicalController;
import com.example.realTemp.service.DriverServiceImpl;
import com.example.realTemp.service.VehicalServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VehicalServiceImplAspect {
    Logger logger = LoggerFactory.getLogger(VehicalServiceImpl.class);
    @Before(value="execution(* com.example.realTemp.service.VehicalServiceImpl..*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info(" (Before) In method : " + joinPoint.getSignature().getName());
    }

    @After(value="execution(* com.example.realTemp.service.VehicalServiceImpl..*(..))")
    public void AfterAdvice(JoinPoint joinPoint){
        logger.info(" (After) In method :" + joinPoint.getSignature().getName());
    }





}
