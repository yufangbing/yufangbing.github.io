package com.example.yu.demo.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String login(){
        return "home/login";
    }

    @GetMapping(value = "/index")
    public String index(){
        return "home/index";
    }

    @GetMapping(value = "/member-list")
    public String memberList(){
        return "member/member-list";
    }

    @GetMapping(value = "/member-del")
    public String memberDel(){
        return "member/member-del";
    }

    @GetMapping(value = "/order-list")
    public String orderList(){
        return "order/order-list";
    }

    @GetMapping(value = "/admin-list")
    public String adminList(){
        return "admin/admin-list";
    }

    @GetMapping(value = "/admin-role")
    public String adminRole(){
        return "admin/admin-role";
    }

    @GetMapping(value = "/admin-cate")
    public String adminCate(){
        return "admin/admin-cate";
    }

    @GetMapping(value = "/admin-rule")
    public String adminRule(){
        return "admin/admin-rule";
    }

    @GetMapping(value = "/echarts1")
    public String echarts1(){
        return "echarts/echarts1";
    }

    @GetMapping(value = "/echarts2")
    public String echarts2(){
        return "echarts/echarts2";
    }

    @GetMapping(value = "/echarts3")
    public String echarts3(){
        return "echarts/echarts3";
    }

    @GetMapping(value = "/echarts4")
    public String echarts4(){
        return "echarts/echarts4";
    }

    @GetMapping(value = "/echarts5")
    public String echarts5(){
        return "echarts/echarts5";
    }

    @GetMapping(value = "/echarts6")
    public String echarts6(){
        return "echarts/echarts6";
    }
    @GetMapping(value = "/echarts7")
    public String echarts7(){
        return "echarts/echarts7";
    }

    @GetMapping(value = "/echarts8")
    public String echarts8(){
        return "echarts/echarts8";
    }

    @GetMapping(value = "/unicode")
    public String unicode(){
        return "home/unicode";
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "home/welcome";
    }

    @GetMapping(value = "/home")
    public String home(){
        return "uiHome/index";
    }










}
