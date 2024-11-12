package com.example.yin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.model.domin.Consumer;
import com.example.yin.common.R;
import org.springframework.web.multipart.MultipartFile;
import com.example.yin.model.request.ConsumerRequest;

import javax.servlet.http.HttpSession;

public interface ConsumerService extends IService<Consumer> {
    /*验证密码是否正确*/
    R verityPasswd(ConsumerRequest consumerRequest, HttpSession session);

    R addUser(ConsumerRequest registryRequest);

    R updateUserMsg(ConsumerRequest updateRequest);

    R updateUserAvator(MultipartFile avatorFile, int id);

    R updatePassword(ConsumerRequest updatePasswordRequest);

    boolean existUser(String username);

    boolean verityPasswd(String username, String password);

    R deleteUser(Integer id);

    R allUser();

    R userOfId(Integer id);

    R loginStatus(ConsumerRequest loginRequest, HttpSession session);
    R updatePassword01(ConsumerRequest updatePasswordRequest);
    /**增加*/
   /* public Boolean insert(Consumer consumer);
    *//**修改*//*
    public  Boolean update(Consumer consumer);
    *//**删除*//*
    public  Boolean delete(Integer id);
    *//**查询所有用户*//*
    public List<Consumer> allConsumer();
    *//**修改密码*//*
    public Boolean editPassword(String username,String password);
    *//**根据用户名查询*//*
    public List<Consumer> getByUsername(String username);*/


}
