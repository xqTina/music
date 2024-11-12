package com.example.yin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.yin.model.domin.Collect;
import com.example.yin.model.domin.Comment;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper extends BaseMapper<Collect> {




   /* *//*增加*//*
    public int insert(Collect collect);
    *//*删除*//*
    public  int delete(Integer id);
    *//*查询所有收藏*//*
    public List<Collect> allCollect();
    *//*查询某个用户下的收藏列表*//*
    public List<Collect> collectOfUserId(Integer userId);
    *//*查询某个用户是否已经收藏了某个歌曲*//*
    public int existSongId(@Param("userId") Integer userId, @Param("songOd") Integer songId);
    *//*查询某个用户是否已经收藏了某个歌单*//*
    public int existSongListId(@Param("userId")Integer userId,@Param("songListId")Integer songListId)*/;

}
