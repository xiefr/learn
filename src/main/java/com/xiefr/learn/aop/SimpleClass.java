package com.xiefr.learn.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 2018-5-10
 * @author xiefr
 *
 */
@Component
public class SimpleClass {
    
    private static final Logger log = LoggerFactory.getLogger(SimpleClass.class);
    
    @Autowired
    SimpleClass simpleClass;

    public void interfaceMethod() {
        log.info("interface Method!");
    }

    
    public void callInterfaceMethod() {
        log.info("callInterfaceMethod Method!");
        /*
         * 这里调用interfaceMethod是不会被AOP代理拦截的
         * 因为此时interfaceMethod()其实是this.interfaceMethod()
         * 而此时的this已经是被代理的目标对象，而不是代理对象本身
         */
        interfaceMethod();
    }
    

    public void callInterfaceMethod2() {
        log.info("callInterfaceMethod2 Method!");
        /*
         * 这里调用interfaceMethod是会被AOP代理拦截的
         * 因为此时simpleClass指向的就是代理对象
         */
        simpleClass.interfaceMethod();
        
    }
}
