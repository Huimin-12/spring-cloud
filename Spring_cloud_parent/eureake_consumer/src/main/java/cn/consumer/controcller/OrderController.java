package cn.consumer.controcller;

import cn.consumer.domain.Goos;
import cn.consumer.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
    //2、注入Bean
    @Autowired
    private RestTemplateConfig restTemplateConfig;
    @Autowired
    private DiscoveryClient discoveryClient;
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
        
        /*
        动态的获取 provider 的ip 跟 端口
        注入 DiscoveryClient ,
        在ConSumerApp当中激活DiscoveryClient
         */
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA_PROVIDER");
        //判断获取到的instances集合当中是否有数据
        if (instances==null||instances.size()==0){
            //进入循环说明集合没有数据
            return null;
        }
        //获取集合当中下标为0 的
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();//获取ip
        int port = instance.getPort();//获取端口
        System.out.println(host+":::"+port);
        String url = "http://"+host+":"+port+"/goos/findOne/"+id;
        //3、调用方法
        Goos goos = restTemplateConfig.restTemplate().getForObject(url, Goos.class);
        //Goos goos = restTemplate.getForObject(url, Goos.class);
        return goos;
    }
    @GetMapping("/findOrder2/{id}")
    public Goos findOrderById2(@PathVariable("id") int id){
        System.out.println("findOrderById22222222,,,被访问");
        /*  远程调用Goos服务方方法 findOne
           使用 RestTemplate
           1、创建ResTemplate Bean
           2、注入Bean
           3、调用方法
         */
        String url = "http://EUREKA-PROVIDER/goos/findOne/"+id;
        //3、调用方法
        Goos goos = restTemplate.getForObject(url, Goos.class);
        return goos;
    }
}
