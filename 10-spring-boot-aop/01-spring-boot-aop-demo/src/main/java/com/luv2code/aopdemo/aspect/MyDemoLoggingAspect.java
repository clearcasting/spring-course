package com.luv2code.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // specify path to run only on specific method
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")

    // use wildcard * to match any method matching everything to the left of the *
//    @Before("execution(public void add*())")

    // modifier is optional, can use wildcard to match any return type
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
