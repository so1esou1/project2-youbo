package com.csu.vo;

import com.csu.entity.Comment;
import lombok.Data;


//评论相关的用户信息
@Data
public class CommentVo extends Comment {

    private Long authorId;  //评论者id
    private String authorName;  //评论者名字
    private String authorAvatar;    //头像

}
