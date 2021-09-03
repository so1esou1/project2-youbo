package com.csu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csu.entity.UserMessage;
import com.csu.mapper.UserMessageMapper;
import com.csu.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageService {

    @Autowired
    UserMessageMapper messageMapper;

    //个人消息的分页：
    @Override
    public IPage paging(Page page, QueryWrapper<UserMessage> wrapper) {
        return messageMapper.selectMessages(page, wrapper);
    }

    //消息变成已读
    @Override
    public void updateToReaded(List<Long> ids) {
        if(ids.isEmpty()) return;

        messageMapper.updateToReaded(new QueryWrapper<UserMessage>()
            .in("id", ids)
        );

    }
}
