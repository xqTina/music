package com.example.yin.service.impl.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yin.common.R;
import com.example.yin.mapper.SongListMapper;
import com.example.yin.model.domin.Comment;
import com.example.yin.model.domin.SongList;
import com.example.yin.service.impl.SongListService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class SongListServiceImpl  implements SongListService {
    private SongListMapper songListMapper;

    @Value("user01")
    String bucketName;

    @Override
    public R allSongList() {
        return R.success(null, songListMapper.selectList(null));
    }

    @Override
    public List<SongList> findAllSong() {
        List<SongList> songLists = songListMapper.selectList(null);
        return songLists;
    }

    @Override
    public R likeStyle(String s) {
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        Object title = null;
        queryWrapper.like("title",title);
        return R.success(null, songListMapper.selectList(queryWrapper));
    }

    @Override
    public R likeTitle(String s) {
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        Object style = null;
        queryWrapper.like("style",style);
        return R.success(null, songListMapper.selectList(queryWrapper));
    }
    


}
