package com.example.yin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.yin.model.domin.Collect;
import com.example.yin.model.domin.Comment;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper extends BaseMapper<Comment> {
    /*增加*/
    public int insert(Collect collect);
    /**/
    public int update(Collect collect);
    /*删除*/
    public  int delete(Integer id);
    /*查询所有收藏*/
    public List<Collect> allCollect();
    /*查询某个用户下的收藏列表*/
    public List<Collect> collectOfUserId(Integer userId);
    /*查询某个用户是否已经收藏了某个歌曲*/
    public List<Collect> existSongId(Integer songListId);
    /*查询某个用户是否已经收藏了某个歌单*/
    public List<Collect> existSongListId(Integer songListId);

}
