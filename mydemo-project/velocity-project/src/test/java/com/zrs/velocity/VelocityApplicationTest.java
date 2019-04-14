package com.zrs.velocity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VelocityApplicationTest {

    @Test
    public void contextLoads() {
    }



    @Test
    public void velocityTest(){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");
     }

}
