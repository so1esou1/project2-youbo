package com.csu.schedules;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csu.entity.Post;
import com.csu.service.PostService;
import com.csu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


//设置定时器，定时刷新阅读量的缓存：
@Component
public class ViewCountSyncTask {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    PostService postService;


    @Scheduled(cron = "0/5 * * * * *")      //cron表达式，每5s同步一次
    public void task() {

        Set<String> keys = redisTemplate.keys("rank:post:*");

        List<String> ids = new ArrayList<>();
        //获取所有的key，如果有"post:viewCount"就同步，没有就不同步
        for (String key : keys) {
            if(redisUtil.hHasKey(key, "post:viewCount")){   //判断有无这个item，没有说明没看过这个文章
                ids.add(key.substring("rank:post:".length()));
            }
        }

        if(ids.isEmpty()) return;       //没有的话直接返回

        //有的话：
        // 需要更新的阅读量
        List<Post> posts = postService.list(new QueryWrapper<Post>().in("id", ids));

        posts.stream().forEach((post) ->{
            Integer viewCount = (Integer) redisUtil.hget("rank:post:" + post.getId(), "post:viewCount");
            post.setViewCount(viewCount);
        });

        if(posts.isEmpty()) return;

        //是否成功：
        boolean isSucc = postService.updateBatchById(posts);

        //成功的话就把缓存中的key删除
        if(isSucc) {
            ids.stream().forEach((id) -> {
                redisUtil.hdel("rank:post:" + id, "post:viewCount");
                System.out.println(id + "---------------------->同步成功");
            });
        }
    }

}
