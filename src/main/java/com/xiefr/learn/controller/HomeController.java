package com.xiefr.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 2018-5-7
 * web测试
 * 实测发现以下四种REST均可用
 * 原因：SpringMVC是通过反射调用Controller的，所以对权限修饰符没有特别要求，除非启动参数加了不允许反射获权
 * 拓展：学习SpringMVC的原理 
 * 结论：平时Controller中可用default（看起来简洁），或者private（缩小作用域）
 * @author xiefr
 *
 */
@RestController
public class HomeController {
    
    @RequestMapping("/public")
    public String helloWorldPublic() {
        return "public hello world";
    }
    
    @RequestMapping("/default")
    String helloWorldDefault() {
        return "default hello world";
    }
    
    @RequestMapping("/protected")
    protected String helloWorldProtected() {
        return "protected hello world";
    }
    
    @RequestMapping("/private")
    private String helloWorldPrivate() {
        return "private hello world";
    }
}
