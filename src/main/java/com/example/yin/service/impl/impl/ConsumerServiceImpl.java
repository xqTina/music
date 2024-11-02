package com.example.yin.service.impl.impl;

import com.example.yin.mapper.ConsumerMapper;
import com.example.yin.model.domin.Consumer;
import com.example.yin.service.impl.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;
    @Override
    public Boolean verifyPassword(String username, String password) {
        return consumerMapper.verifyPassword(username,password)>0;

    }

    /**
     * 增加
     *
     * @param consumer
     */
    @Override
    public Boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0;
    }

    /**
     * 修改
     *
     * @param consumer
     */
    @Override
    public Boolean update(Consumer consumer) {
        return consumerMapper.update(consumer)>0;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public Boolean delete(Integer id) {
        return consumerMapper.delete(id)>0;
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<Consumer> allConsumer() {
        return consumerMapper.allConsumer();
    }

    /**
     * 修改密码
     *
     * @param username
     * @param password
     */
    @Override
    public Boolean editPassword(String username, String password) {
        return consumerMapper.editPassword(username,password)>0;
    }

    /**
     * 根据用户名查询
     *
     * @param username
     */
    @Override
    public List<Consumer> getByUsername(String username) {
        return consumerMapper.getByUsername(username);
    }
}
