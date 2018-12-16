package com.example.yu.demo.aop;


import com.example.yu.demo.service.userInfo.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 切片类，可以定义切入点，在切入点之前，之后，或者环绕处  执行切片逻辑
 * eg：在增加修改后，增加操作日志操作
 */
@Component
@Aspect
public class DemoAspect {

    @Autowired
    private UserService userService;


    /**
     * 切入点：查询user时
     */
    @Pointcut("execution(* com.example.yu.demo.controller.userInfo.UserController.getAllUsers(..))")
    public void saveInfo(){}

    /**
     * 处理切片类业务逻辑
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "saveInfo()",returning = "result")
    public void savePointCut(JoinPoint joinPoint,Object result){
        //方法参数
        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        Map<String,Object> params = (Map<String,Object>)arg;
        //方法返回的结果
        List<Map<String,Object>> results = (List<Map<String,Object>>)result;
        //自己需要执行的后续操作
        userService.findAllUser();
    }




}
