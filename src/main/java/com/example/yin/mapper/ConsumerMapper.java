package com.example.yin.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerMapper {
    /*验证密码是否正确*/

    public  int verifyPassword(String username,String password);


}
