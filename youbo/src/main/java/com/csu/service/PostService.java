package com.csu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csu.entity.Post;
import com.csu.vo.PostVo;


public interface PostService extends IService<Post> {

    //页数信息，文章id，作者id，等级，是否佳作，order
    IPage paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    PostVo selectOnePost(QueryWrapper<Post> wrapper);

    void initWeekRank();

    //其他人阅读时，在缓存中将文章阅读量+1的方法：
    void incrCommentCountAndUnionForWeekRank(long postId, boolean isIncr);

    //显示文章阅读量
    void putViewCount(PostVo vo);
}
