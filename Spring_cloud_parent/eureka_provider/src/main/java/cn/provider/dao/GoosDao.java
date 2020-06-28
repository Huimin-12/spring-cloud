package cn.provider.dao;

import cn.provider.domain.Goos;
import org.springframework.stereotype.Repository;

//商品Dao层
@Repository
public class GoosDao {

    public Goos finOneById(int id){
        return new Goos(1,"三星手机品牌",4888,50000);
    }
}
