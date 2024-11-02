package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.model.domin.Consumer;
import com.example.yin.service.impl.ConsumerService;
import com.example.yin.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/login/status",method = RequestMethod.POST)
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

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addConsumer(HttpServletRequest request){
        JSONObject jsonObject =  new JSONObject();
        String username = request.getParameter("username").trim();
        String password =  request.getParameter("password").trim();
        String sex = request.getParameter("sex").trim();
        String phoneNum = request.getParameter("phoneNum").trim();
        String birth = request.getParameter("birth").trim();
        String introduction = request.getParameter("introduction").trim();
        String location = request.getParameter("location").trim();
        String avator = request.getParameter("avator").trim();

        if (username == null || username.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }
        if (password == null || password.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码不能为空");
            return jsonObject;
        }
        //将生日转换成Date格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try{
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Consumer consumer = new Consumer();
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setPhoneNum(phoneNum);
        consumer.setBirth(birthDate);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        consumer.setAvator(avator);
        Boolean flag = consumerService.insert(consumer);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateConsumer(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String username = request.getParameter("username").trim();
        String password =  request.getParameter("password").trim();
        String sex = request.getParameter("sex").trim();
        String phoneNum = request.getParameter("phoneNum").trim();
        String birth = request.getParameter("birth").trim();
        String introduction = request.getParameter("introduction").trim();
        String location = request.getParameter("location").trim();
        String avator = request.getParameter("avator").trim();

        if (username == null || username.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }
        if (password == null || password.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码不能为空");
            return jsonObject;
        }
        //将生日转换成Date格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try{
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Consumer consumer =new Consumer();
        consumer.setId(Integer.parseInt(id));
        consumer.setUsername(username);
        consumer.setPassword(password);
        consumer.setSex(new Byte(sex));
        consumer.setPhoneNum(phoneNum);
        consumer.setBirth(birthDate);
        consumer.setIntroduction(introduction);
        consumer.setLocation(location);
        Boolean flag = consumerService.insert(consumer);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteConsumer(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        Boolean flag = consumerService.delete(Integer.parseInt(id));
        return flag;
    }
    /*更新用户图片*/
    @RequestMapping(value = "/updateConsumerPic",method = RequestMethod.POST)
    public Object updateConsumerPic(@RequestParam("file")MultipartFile avatorFile ,@RequestParam("id") int id){
        JSONObject jsonObject =new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
            return jsonObject;
        }
        //文件名=当前时间到毫秒+原来文件名
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath = System.getProperty("username.dir")+System.getProperty("file.separator")+"img/avatorImages";
        File file1= new File(filePath);
        if(file1.exists()){
            file1.mkdir();
        }
        //实际文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        String storeAvatorPath = "/img/avatorImages"+fileName;
        try{
            avatorFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvator(storeAvatorPath);
            boolean flag =consumerService.update(consumer);
            if (flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("avator",storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
        }finally {
            return jsonObject;
        }

    }
}
