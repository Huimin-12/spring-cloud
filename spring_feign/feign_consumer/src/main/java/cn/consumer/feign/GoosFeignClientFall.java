package cn.consumer.feign;

import cn.consumer.domain.Goos;
import org.springframework.stereotype.Component;
/*
    消费方降级类
 */
@Component
public class GoosFeignClientFall implements GoosFeignClient{

    @Override
    public Goos findOneById(int id) {
        Goos goos = new Goos();
        goos.setName("消费方降级了！！！！");
        return goos;
    }
}
