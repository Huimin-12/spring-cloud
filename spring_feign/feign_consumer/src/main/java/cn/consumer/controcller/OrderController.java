package cn.consumer.controcller;

import cn.consumer.domain.Goos;
import cn.consumer.feign.GoosFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    //2、注入Bean
    @Autowired
    private GoosFeignClient goosFeignClient;
    @GetMapping("/findOrder/{id}")
    public Goos findOrderById(@PathVariable("id") int id){
        Goos goos = goosFeignClient.findOneById(id);
        return goos;
    }
}
