package com.example.yu.demo.service.userInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    List findAllUser();

    List<Map<String,Object>> getAll(Map<String,Object> params);

    Integer count(Map<String,Object> params);

    Integer add(Map<String,Object> params);

    Integer del(Map<String,Object> params);

    Integer update(Map<String,Object> params);

    List<Map<String,Object>> selectBatch(List<Map<String,Object>> list);
}
