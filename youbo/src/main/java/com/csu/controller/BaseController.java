package com.csu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csu.service.*;
import com.csu.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    @Autowired
    HttpServletRequest req;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;      //评论的信息

    @Autowired
    UserService userService;        //用户信息

    @Autowired
    UserMessageService messageService;

    @Autowired
    UserCollectionService collectionService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    WsService wsService;

    @Autowired
    SearchService searchService;


    @Autowired
    ChatService chatService;







    //得到页数：
    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 2);
        return new Page(pn, size);
    }

    //得到用户权限信息：
    protected AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

    //获取用户信息：
    protected Long getProfileId() {
        return getProfile().getId();
    }
}
