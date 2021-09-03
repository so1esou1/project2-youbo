package com.csu.template;

import com.csu.common.templates.DirectiveHandler;
import com.csu.common.templates.TemplateDirective;
import com.csu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 热点文章的模板
 */
@Component
public class HotsTemplate extends TemplateDirective {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String getName() {
        return "hots";
    }

    //获取热点文章：
    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        String weekRankKey = "week:rank";       //每周的热点文章

        Set<ZSetOperations.TypedTuple> typedTuples = redisUtil.getZSetRank(weekRankKey, 0, 6);

        List<Map> hotPosts = new ArrayList<>();

        for (ZSetOperations.TypedTuple typedTuple : typedTuples) {
            Map<String, Object> map = new HashMap<>();

            Object value = typedTuple.getValue(); // post的id
            String postKey = "rank:post:" + value;

            //把文章的信息放进map集合中：
            map.put("id", value);
            map.put("title", redisUtil.hget(postKey, "post:title"));
            map.put("commentCount", typedTuple.getScore());     //评论数量

            hotPosts.add(map);
        }

        handler.put(RESULTS, hotPosts).render();

    }
}
