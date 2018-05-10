package com.xiefr.learn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 2018-5-8
 * @author xiefr
 *
 */
@RunWith(SpringRunner.class)  
@SpringBootTest  
public class HomeControllerTest {
    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。    
    
    @Autowired    
    private WebApplicationContext wac; // 注入WebApplicationContext
    
    @Before // 在测试开始前初始化工作    
    public void setup() {    
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();    
    } 
    
    @Test
    public void helloWorldPublicTest() throws Exception {
        mockMvc.perform(post("/public")).andExpect(status().isOk());
    }
    
    @Test
    public void helloWorldDefaultTest() throws Exception {
        mockMvc.perform(post("/default")).andExpect(status().isOk());
    }
    
    @Test
    public void helloWorldProtectedTest() throws Exception {
        mockMvc.perform(post("/protected")).andExpect(status().isOk());
    }
    
    @Test
    public void helloWorldPrivateTest() throws Exception {
        mockMvc.perform(post("/private")).andExpect(status().isOk());
    }
}
