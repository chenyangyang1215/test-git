package com.hisoft.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;
@Aspect
@Component("logger")
public class UserServiceLogger {
    private static final Logger logger =Logger.getLogger("UserServiceLogger.class");
    @Pointcut(value = "execution(public * com.hisoft.service..*.*(..))")
    public void protuct(){}
    //前置增强
    @Before(value = "protuct()")
    public void before (JoinPoint jp){
        logger.info("前置增强：调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,方法入参"+ Arrays.toString(jp.getArgs()));

    }
    //后置增强
    @AfterReturning(value = "protuct()",returning ="result")
    public void after (JoinPoint jp,Object result){
        logger.info("后置增强：调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,方法返回值"+result);

    }
    //异常增强处理
    @AfterThrowing(value = "protuct()",throwing = "e")
    public void afterthrow (JoinPoint jp,Exception e){
        logger.info("异常增强：调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,抛出异常："+e);

    }
    //最终增强处理
    @After(value = "protuct()")
    public void afterfinally (JoinPoint jp){
        logger.info("最终增强:调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,方法执行结束");

    }
    //环绕增强处理
    @Around(value = "protuct()")
    public void around (ProceedingJoinPoint jp){
        logger.info("环绕增强：方法执行前，调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,参数列表："+Arrays.toString(jp.getArgs()));
       Object result =null;
        try {
           result = jp.proceed();//执行目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,抛出异常："+throwable);
        }finally {
            logger.info("环绕增强：方法执行结束调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法,返回值"+result);
        }
    }
}
