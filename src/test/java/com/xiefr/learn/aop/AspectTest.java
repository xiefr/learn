package com.xiefr.learn.aop;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 2018-5-10
 * @author xiefr
 * 对SpringAOP的测试类（前提：spring.aop.proxy-target-class=false）
 */
@RunWith(SpringRunner.class)  
@SpringBootTest  
public class AspectTest {

    
    private static final Logger log = LoggerFactory.getLogger(AspectTest.class);

   
    @Autowired
    DemoInterface demoInterface;
    @Autowired
    SimpleClass simpleClass;
    /*
     * 如果类型使用DemoInterfaceImpl而不是接口的话，会导致类型不匹配报错，这是由于DemoInterfaceImpl有接口，
     * 所以自动使用JAVA动态代理进行实现，所以注入类是一个DemoInterface的实现，无法注入到DemoInterfaceImpl类中
     * 当然如果开启了aop.proxy-target-class=true的话就没问题，因为强制使用CGLIB方式实现
     */
    
  
    @Test
    public void aspectTest() {
        // java动态代理对象是Proxy类
        assertTrue(demoInterface instanceof Proxy);
        // CGLIB代理对象是目标对象的子类
        assertTrue(SimpleClass.class.isAssignableFrom(simpleClass.getClass()));
        
        log.info("########JDK dynamic proxy#######");
        // 正常被AOP代理拦截
        demoInterface.interfaceMethod();
        log.info("################################");
        // 自己本身正常被AOP代理拦截，方法内部调用interfaceMethod不会被拦截
        demoInterface.callInterfaceMethod();
        log.info("################################");
        // 自己本身正常被AOP代理拦截，方法内部通过特殊方式调用interfaceMethod会被拦截
        demoInterface.callInterfaceMethod2();
        log.info("################################");
        
        log.info("########CGLIB proxy#############");
        // 正常被AOP代理拦截
        simpleClass.interfaceMethod();
        log.info("################################");
        // 自己本身正常被AOP代理拦截，方法内部调用interfaceMethod不会被拦截
        simpleClass.callInterfaceMethod();
        log.info("################################");
        // 自己本身正常被AOP代理拦截，方法内部通过特殊方式调用interfaceMethod会被拦截
        simpleClass.callInterfaceMethod2();
        log.info("################################");
    }
}
