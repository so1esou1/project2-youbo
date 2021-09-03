package com.csu.vo;

import com.csu.entity.Post;
import lombok.Data;

@Data
public class PostVo extends Post {

    private Long authorId;  //作者id
    private String authorName;      //作者名
    private String authorAvatar;    //作者头像

    private String categoryName;        //文章名

}
