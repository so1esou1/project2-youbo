package com.csu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csu.entity.Comment;
import com.csu.mapper.CommentMapper;
import com.csu.service.CommentService;
import com.csu.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public IPage<CommentVo> paing(Page page, Long postId, Long userId, String order) {
        return commentMapper.selectComments(page, new QueryWrapper<Comment>()
                .eq(postId != null, "post_id", postId)
                .eq(userId != null, "user_id", userId)
                .orderByDesc(order != null, order)
        );
    }
}
