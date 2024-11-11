package com.example.yin.service.impl.impl;

import com.example.yin.mapper.CollectMapper;
import com.example.yin.model.domin.Collect;
import com.example.yin.service.impl.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public Boolean insert(Collect collect) {
        return collectMapper.insert(collect)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return collectMapper.delete(id)>0;
    }

    @Override
    public List<Collect> allCollect() {
        return collectMapper.allCollect();
    }

    @Override
    public List<Collect> collectOfUserId(Integer userId) {
        return collectMapper.collectOfUserId(userId);
    }

    @Override
    public Boolean existSongId(Integer userId, Integer songId) {
        return collectMapper.existSongId(userId,songId)>0;
    }

    @Override
    public Boolean existSongListId(Integer userId, Integer songListId) {
        return collectMapper.existSongListId(userId,songListId)>0;
    }
}
