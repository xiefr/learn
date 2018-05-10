package com.xiefr.learn.aop;
/**
 * 2018-5-10
 * @author xiefr
 * 
 */
public interface DemoInterface {
    /**
     * 一个普通的方法
     */
    void interfaceMethod();
    /**
     * 调用内部其他方法，测试动态代理边界问题
     */
    void callInterfaceMethod();
    /**
     * 调用内部其他方法2，测试动态代理边界问题
     */
    void callInterfaceMethod2();
}
