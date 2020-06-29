package cn.provider.service;

import cn.provider.dao.GoosDao;
import cn.provider.domain.Goos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoosService {

    @Autowired
    private GoosDao goosDao;

    public Goos findOneById(int id){
        return goosDao.finOneById(id);
    }
}
