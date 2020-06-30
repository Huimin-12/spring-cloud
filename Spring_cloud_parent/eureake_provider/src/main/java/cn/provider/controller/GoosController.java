package cn.provider.controller;

import cn.provider.domain.Goos;
import cn.provider.service.GoosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goos")
public class GoosController {

    @Autowired
    private GoosService goosService;
    @Value("${server.port}")
    private int port;

    @GetMapping("/findOne/{id}")

    public Goos findOneById(@PathVariable int id){
        Goos goos = goosService.findOneById(id);
        goos.setName(goos.getName()+":"+port);
        return goos;
    }
}
