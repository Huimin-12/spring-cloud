package cn.consumer.feign;


import cn.consumer.config.LoggerConfig;
import cn.consumer.domain.Goos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
    feign声明式接口，发起远程调用的，
        替换controller当中的这两行代码
        String url = "http://EUREKA-PROVIDER/goos/findOne/"+id;
        Goos goos = restTemplate.getForObject(url, Goos.class);

      1、定义接口
      2、在接口上添加一个@FeignClient,设置value属性为服务方的应用名称
 */
@FeignClient(value = "EUREKA-PROVIDER",configuration = LoggerConfig.class,fallback = GoosFeignClientFall.class)
public interface GoosFeignClient {
    @GetMapping("/goos/findOne/{id}")
    public Goos findOneById(@PathVariable("id") int id);
}
