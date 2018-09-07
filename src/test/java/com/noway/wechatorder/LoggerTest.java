package com.noway.wechatorder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PipedWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //    private final Logger log =LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1() {
        //系统默认级别是info
        //级别由高到低 error > warn > info > debug > trace
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
        //todo 输出
//        2018-09-07 12:21:24.954  INFO 9780 --- [           main] com.noway.wechatorder.LoggerTest         : info...
//        2018-09-07 12:21:24.954 ERROR 9780 --- [           main] com.noway.wechatorder.LoggerTest         : error...


        String name = "noway";
        String password = "123456";
        log.info("name:" + name + ",password:" + password);
        //高级写法
          log.info("name:{},password:{}",name,password);

    }
}
