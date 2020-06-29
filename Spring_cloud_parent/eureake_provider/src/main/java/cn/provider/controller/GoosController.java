package cn.provider.controller;

import cn.provider.domain.Goos;
import cn.provider.service.GoosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goos")
public class GoosController {

    @Autowired
    private GoosService goosService;

    @GetMapping("/findOne/{id}")
    public Goos findOneById(@PathVariable int id){

        return goosService.findOneById(id);
    }
}
