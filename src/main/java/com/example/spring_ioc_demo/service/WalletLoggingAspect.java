package com.example.spring_ioc_demo.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WalletLoggingAspect {

    @Before("execution(* com.example.spring_ioc_demo.service.*.*(..))")
    public void logBefore() {
        System.out.println("Wallet service method started");
    }
}