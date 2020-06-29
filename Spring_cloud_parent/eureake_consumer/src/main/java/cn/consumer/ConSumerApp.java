package cn.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableDiscoveryClient//激活DiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class ConSumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConSumerApp.class,args);
    }
}
