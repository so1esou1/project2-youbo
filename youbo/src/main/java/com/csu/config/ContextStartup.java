package com.csu.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csu.entity.Category;
import com.csu.service.CategoryService;
import com.csu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

//项目一旦启动，会先进行这个类的实现:
//
@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    @Autowired
    CategoryService categoryService;

    ServletContext servletContext;

    @Autowired
    PostService postService;

    //项目一旦启动就调用这个内容:
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //条件筛选：看是否上线
        List<Category> categories = categoryService.list(new QueryWrapper<Category>()
                .eq("status", 0)
        );
        servletContext.setAttribute("categorys", categories);

        postService.initWeekRank(); //这行代码是初始化热点文章的功能
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
