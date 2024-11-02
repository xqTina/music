package com.example.yin.mapper;

import com.example.yin.model.domin.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerMapper {
    /*验证密码是否正确*/
    public  int verifyPassword(String username,String password);
    /**增加*/
    public int insert(Consumer consumer);
    /**修改*/
    public  int update(Consumer consumer);
    /**删除*/
    public  int delete(Integer id);
    /**查询所有用户*/
    public List<Consumer> allConsumer();
    /**验证密码*/
    public int editPassword(String username,String password);
    /**根据用户名查询*/
    public List<Consumer> getByUsername(String username);


}
