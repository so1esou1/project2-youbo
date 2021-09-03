package com.csu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling       //有这个才能使用计时器的功能
@SpringBootApplication
public class YouBoApplication {

    public static void main(String[] args) {

        // 解决elasticsearch启动保存问题
        System.setProperty("es.set.netty.runtime.available.processors", "false");


        SpringApplication.run(YouBoApplication.class, args);
        System.out.println("http://localhost:8081启动");
    }
}
