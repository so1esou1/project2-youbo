package com.csu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csu.entity.UserMessage;
import com.csu.service.UserMessageService;
import com.csu.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WsServiceImpl implements WsService {

    @Autowired
    UserMessageService messageService;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Async
    @Override
    public void sendMessCountToUser(Long toUserId) {
        int count = messageService.count(new QueryWrapper<UserMessage>()
                .eq("to_user_id", toUserId)
                .eq("status", "0")
        );

        // websocket通知 (/user/20/messCount)
        messagingTemplate.convertAndSendToUser(toUserId.toString(), "/messCount", count);
    }
}
