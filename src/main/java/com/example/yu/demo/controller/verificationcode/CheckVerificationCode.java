package com.example.yu.demo.controller.verificationcode;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 校验验证码
 */
@RestController
public class CheckVerificationCode {


    @PostMapping(value = "/checkCode")
    protected String doPost(@RequestBody Map<String,Object> map, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = "200";
        String code = "";
        if(null != map.get("code")){
            code = map.get("code").toString();
        }
        // 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();

        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
            if (code.equalsIgnoreCase(sessionCode)) {
//                response.getWriter().println("验证通过！");
            } else {
//                response.getWriter().println("验证失败！");
                state = "验证失败";
            }
        } else {
            response.getWriter().println("验证失败！");
            state = "验证失败";
        }

        return state;
    }

}
