package cn.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer//启动Config Server 功能
@EnableEurekaClient
public class ConfigServerApp {
    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApp.class,args);
    }
}
