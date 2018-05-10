package com.xiefr.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 2018-5-10
 * @author xiefr
 * SpringAOP 示例
 */
@Aspect
@Component
public class AspectDemo {
    
    private static final Logger log = LoggerFactory.getLogger(AspectDemo.class);

    
    @Pointcut("execution(* com.xiefr.learn.aop.*.*(..))")
    public void beforePointcut() {}
    
    @Before(value = "beforePointcut()")
    public void before(JoinPoint point) {
        if (log.isInfoEnabled()) {
            String className = point.getTarget().getClass().getSimpleName();
            String methodName = point.getSignature().getName();
            log.info("className:"+className+" method:"+methodName);
        }
    }
}
