package com.xuegao.mybatisdemo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Aspect
// @Profile({"dev"})
public class MapperExecuteAopV2 implements ApplicationContextAware {
    Logger logger = LoggerFactory.getLogger(MapperExecuteAopV2.class);
    ApplicationContext context;

    public MapperExecuteAopV2() {
    }

    // @Around("@annotation(org.apache.ibatis.annotations.Mapper)")
    // @Around("execution(public * *(..))")
    @Around("execution(* *..*Mapper.*(..))")
    public Object rounding(ProceedingJoinPoint joinPoint) throws Throwable {
        this.logger.info("MapperExecuteAopV2 执行mapper拦截");
        Object proceed = joinPoint.proceed();
        return proceed;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
