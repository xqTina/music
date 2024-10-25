package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.service.impl.ConsumerService;
import com.example.yin.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    @RequestMapping(value = "/consumer/login/status",method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        Boolean flag= consumerService.verifyPassword(username,password);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登录成功");
            session.setAttribute(Consts.USERNAME,username);
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"用户名或密码错误");
        return jsonObject;
    }
}
