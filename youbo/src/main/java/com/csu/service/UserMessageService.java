package com.csu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csu.entity.UserMessage;

import java.util.List;


public interface UserMessageService extends IService<UserMessage> {

    IPage paging(Page page, QueryWrapper<UserMessage> wrapper);

    void updateToReaded(List<Long> ids);
}
