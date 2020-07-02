package cn.provider.controller;

import cn.provider.domain.Goos;
import cn.provider.service.GoosService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;

@RestController
@RequestMapping("/goos")
public class GoosController {

    @Autowired
    private GoosService goosService;
    @Value("${server.port}")
    private int port;

    @GetMapping("/findOne/{id}")
    @HystrixCommand(fallbackMethod = "findOneById_fall")
    public Goos findOneById(@PathVariable int id,String username){
        System.out.println(username);
        if (id==1){
            int i = 3/0;
        }
       /* try {
            //睡眠3秒，默认超时时间为1秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Goos goos = goosService.findOneById(id);
        goos.setName(goos.getName()+":"+port);
        return goos;
    }
    /*
        定义降级方法，以下都会触发降级方法
        1、出异常
        2、连接超时
     */
    public Goos findOneById_fall(int id,String username){
        Goos goos = new Goos();
        goos.setName("服务方降级了~~~");
        return goos;
    }

}
