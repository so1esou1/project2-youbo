package com.csu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{
    @RequestMapping({"", "/", "index"})
    public String index() {

        // 1分页信息 2分类 3用户 4置顶  5佳作 6排序
        //通过分页的方式实现:
        IPage results = postService.paging(getPage(), null, null, null, null, "created");

        req.setAttribute("pageData", results);
        req.setAttribute("currentCategoryId", 0);
        return "index";
    }

    //查询:
    @RequestMapping("/search")
    public String search(String q) {

        IPage pageData = searchService.search(getPage(), q);

        req.setAttribute("q", q);
        req.setAttribute("pageData", pageData);
        return "search";
    }

}
