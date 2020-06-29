package cn.consumer.resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //将该方法的返回值注入到spring容器当中
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
