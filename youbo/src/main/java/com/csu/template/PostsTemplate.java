package com.csu.template;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csu.common.templates.DirectiveHandler;
import com.csu.common.templates.TemplateDirective;
import com.csu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
* 置顶文章的模板
* */
@Component
public class PostsTemplate extends TemplateDirective {

    @Autowired
    PostService postService;

    @Override
    public String getName() {
        return "posts";
    }

    @Override           //获取参数并返回
    public void execute(DirectiveHandler handler) throws Exception {

        //文章的相关信息：
        Integer level = handler.getInteger("level");
        Integer pn = handler.getInteger("pn", 1);
        Integer size = handler.getInteger("size", 2);
        Long categoryId = handler.getLong("categoryId");

        IPage page = postService.paging(new Page(pn, size), categoryId, null, level, null, "created");

        handler.put(RESULTS, page).render();
    }
}
