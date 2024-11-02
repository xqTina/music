package com.example.yin.service.impl;

import com.example.yin.model.domin.Consumer;

import java.util.List;

public interface ConsumerService {
    /*验证密码是否正确*/

    public  Boolean verifyPassword(String username,String password);
    /**增加*/
    public Boolean insert(Consumer consumer);
    /**修改*/
    public  Boolean update(Consumer consumer);
    /**删除*/
    public  Boolean delete(Integer id);
    /**查询所有用户*/
    public List<Consumer> allConsumer();
    /**修改密码*/
    public Boolean editPassword(String username,String password);
    /**根据用户名查询*/
    public List<Consumer> getByUsername(String username);


}
