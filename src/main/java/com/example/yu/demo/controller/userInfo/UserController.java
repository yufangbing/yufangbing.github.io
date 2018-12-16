package com.example.yu.demo.controller.userInfo;

import com.example.yu.demo.service.userInfo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;


    //变量在.yml文件获取
    @Value("${ipdress}")
    private String ipDress;

//    @Value("${name}")
    private String ipDressDetail;

    @RequestMapping(value = {"/findAll"},method = RequestMethod.GET)
    public List getAllUsers(@RequestParam Map<String,Object> params){
        List list =  userService.findAllUser();
        return list;
    }


    @ResponseBody
    @RequestMapping(value = {"/count"},method = RequestMethod.GET)
    public Integer count(@RequestParam Map<String,Object> params){
        Integer count =  userService.count(params);
        return count;
    }

    @ResponseBody
    @RequestMapping(value = {"/add"},method = RequestMethod.POST)
    public Integer add(@RequestBody Map<String,Object> params){
        Integer num =  userService.add(params);
        return num;
    }


    @ResponseBody
    @RequestMapping(value = {"/update"},method = RequestMethod.PUT)
    public Integer update(@RequestBody Map<String,Object> params){
        Integer num =  userService.update(params);
        return num;
    }


    @ResponseBody
    @RequestMapping(value = {"/del"},method = RequestMethod.DELETE)
    public Integer del(@RequestBody Map<String,Object> params){
        Integer num =  userService.del(params);
        return num;
    }






}
