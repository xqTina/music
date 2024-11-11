package com.example.yin.service.impl;

import com.example.yin.model.domin.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectService {
    /*增加*/
    public Boolean insert(Collect collect);
    /*删除*/
    public  Boolean delete(Integer id);
    /*查询所有收藏*/
    public List<Collect> allCollect();
    /*查询某个用户下的收藏列表*/
    public List<Collect> collectOfUserId(Integer userId);
    /*查询某个用户是否已经收藏了某个歌曲*/
    public Boolean existSongId(@Param("userId") Integer userId, @Param("songOd") Integer songId);
    /*查询某个用户是否已经收藏了某个歌单*/
    public Boolean existSongListId(@Param("userId")Integer userId,@Param("songListId")Integer songListId);
}
