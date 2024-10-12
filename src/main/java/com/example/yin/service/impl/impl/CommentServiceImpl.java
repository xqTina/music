package com.example.yin.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yin.common.R;
import com.example.yin.mapper.CommentMapper;
import com.example.yin.model.domin.Comment;
import com.example.yin.model.request.CommentRequest;
import com.example.yin.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public R addComment(CommentRequest addCommentRequest) {
        return null;
    }

    @Override
    public R deleteComment(Integer id) {
        return null;
    }
}
