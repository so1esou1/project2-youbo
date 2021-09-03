package com.csu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csu.entity.Comment;
import com.csu.vo.CommentVo;


public interface CommentService extends IService<Comment> {

    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);
}
