package cn.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//启动Config Server 功能
public class ConfigServerApp {
    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApp.class,args);
    }
}
