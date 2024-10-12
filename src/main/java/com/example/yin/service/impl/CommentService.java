package com.example.yin.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.common.R;
import com.example.yin.model.domin.Comment;
import com.example.yin.model.request.CommentRequest;

public interface CommentService extends IService<Comment> {
    R addComment(CommentRequest addCommentRequest);
    R deleteComment(Integer id);
}
