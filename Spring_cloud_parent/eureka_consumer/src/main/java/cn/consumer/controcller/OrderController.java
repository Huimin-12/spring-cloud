package cn.consumer.controcller;

import cn.consumer.domain.Goos;
import cn.consumer.resttemplate.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    //2、注入Bean
    @Autowired
    private RestTemplateConfig restTemplateConfig;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findOrder/{id}")
    public Goos findOrderById(@PathVariable("id") int id){
        System.out.println("findOrderById,,,被访问");
        /*  远程调用Goos服务方方法 findOne
           使用 RestTemplate
           1、创建ResTemplate Bean
           2、注入Bean
           3、调用方法
         */
        String url = "http://localhost:8000/goos/findOne/1";
        //3、调用方法
        Goos goos = restTemplateConfig.restTemplate().getForObject(url, Goos.class);
        //Goos goos = restTemplate.getForObject(url, Goos.class);
        return goos;
    }
}
