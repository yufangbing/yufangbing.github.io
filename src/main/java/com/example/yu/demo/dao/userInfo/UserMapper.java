package com.example.yu.demo.dao.userInfo;


import com.example.yu.demo.entity.userInfo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询所有接口
     * @return
     */

    List<User> findAllUser();

    List<Map<String, Object>> getAll(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    Integer add(Map<String, Object> params);

    Integer update(Map<String, Object> params);

    Integer del(Map<String, Object> params);

    List<Map<String, Object>> selectBatch(List<Map<String, Object>> list);

}
