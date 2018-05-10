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
public class DemoInterfaceImpl implements DemoInterface {
    
    private static final Logger log = LoggerFactory.getLogger(DemoInterfaceImpl.class);

    /**
     * 自己注入自己
     */
    @Autowired
    DemoInterface demoInterface;
    
    @Override
    public void interfaceMethod() {
        log.info("interface Method!");
    }

    
    @Override
    public void callInterfaceMethod() {
        log.info("callInterfaceMethod Method!");
        /*
         * 这里调用interfaceMethod是不会被AOP代理拦截的
         * 因为此时interfaceMethod()其实是this.interfaceMethod()
         * 而此时的this已经是被代理对象，而不是代理对象本身
         */
        interfaceMethod();
    }
    

    @Override
    public void callInterfaceMethod2() {
        log.info("callInterfaceMethod2 Method!");
        /*
         * 这里调用interfaceMethod是会被AOP代理拦截的
         * 因为此时demoInterface指向的就是代理对象
         */
        demoInterface.interfaceMethod();
        
    }

    /**
     * 类的非接口方法，只有使用GCLIB实现代理的情况下才能被代理
     */
    public void ownMethod() {
        log.info("own Method!");
    }


}
