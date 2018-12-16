package com.example.yu.demo.service.userInfo;

import com.example.yu.demo.dao.userInfo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserMapper userDao;

    @Override
    public List findAllUser() {
        return userDao.findAllUser();
    }


    @Override
    public List<Map<String, Object>> selectBatch(List<Map<String, Object>> list) {
        return userDao.selectBatch(list);
    }



    @Override
    public Integer del(Map<String, Object> params) {
        return userDao.del(params);
    }

    @Override
    public Integer update(Map<String, Object> params) {
        return userDao.update(params);
    }


    @Override
    public Integer count(Map<String, Object> params) {
        return userDao.count(params);
    }

    @Override
    public List<Map<String, Object>> getAll(Map<String, Object> params) {
        return userDao.getAll(params);
    }

    @Override
    public Integer add(Map<String, Object> params) {
        return userDao.add(params);
    }


}
