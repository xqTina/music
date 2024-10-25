package com.example.yin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.common.R;
import com.example.yin.model.domin.Comment;
import com.example.yin.model.domin.SongList;

import java.util.List;

public interface SongListService   {
    R allSongList();

    List<SongList> findAllSong();

    R likeStyle(String s);

    R likeTitle(String s);
}
