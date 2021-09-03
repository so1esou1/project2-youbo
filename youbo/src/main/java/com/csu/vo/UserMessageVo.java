package com.csu.vo;

import com.csu.entity.UserMessage;
import lombok.Data;


//用户消息的类:
@Data
public class UserMessageVo extends UserMessage {

    private String toUserName;
    private String fromUserName;
    private String postTitle;
    private String commentContent;      //评论的内容

}
