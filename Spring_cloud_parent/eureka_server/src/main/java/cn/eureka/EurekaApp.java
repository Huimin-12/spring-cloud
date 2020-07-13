package cn.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 启用EurekaServer
@EnableEurekaServer
public class EurekaApp {
    public static void main(String[] args) {
        //启动类
        SpringApplication.run(EurekaApp.class,args);
    }
}
