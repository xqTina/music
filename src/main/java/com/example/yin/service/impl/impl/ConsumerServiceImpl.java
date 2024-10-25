package com.example.yin.service.impl.impl;

import com.example.yin.mapper.ConsumerMapper;
import com.example.yin.service.impl.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;
    @Override
    public Boolean verifyPassword(String username, String password) {
        return consumerMapper.verifyPassword(username,password)>0;

    }
}
