package nuc.edu.cn.bzr.controller;

import nuc.edu.cn.bzr.mapper.BlogMapper;
import nuc.edu.cn.bzr.mapper.TagMapper;
import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Page;
import nuc.edu.cn.bzr.model.Tag;
import nuc.edu.cn.bzr.model.Type;
import nuc.edu.cn.bzr.service.BlogService;
import nuc.edu.cn.bzr.service.TagService;
import nuc.edu.cn.bzr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/toAdmin")
@Controller
public class ToAdminPage {
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    BlogService blogService;
    @RequestMapping("")
    public String toIndex(Model model) {
        model.addAttribute("blog",new Blog());
        model.addAttribute("tags",tagService.findAllTag());
        model.addAttribute("types",typeService.findAllType());
        return "admin/input";
    }

    @RequestMapping("/input")
    public String toInput(Model model) {
        model.addAttribute("blog",new Blog());
        model.addAttribute("tags",tagService.findAllTag());
        model.addAttribute("types",typeService.findAllType());
        return "admin/input";
    }

    @RequestMapping("/blogs")
    public String toBlog(Model model) {
        Page page = new Page();
        page.setNowcount(0);
        page.setNowpage(0);
        page.setPagecount(14);
        page.setCount(blogService.blogcount());
        if (page.getCount()%page.getPagecount()==0){
            page.setAllpage(page.getCount()/page.getPagecount());
        }else{
            page.setAllpage(page.getCount()/page.getPagecount()+1);
        }
        model.addAttribute("page",page);
        model.addAttribute("blogs",blogService.findAllBlogsAtBlogs(page));
        model.addAttribute("types",typeService.findAllType());
        return "admin/blogs";
    }

    @RequestMapping("/types")
    public String findAllTypes(Model model) {
        List<Type> lists = typeService.findAllType();
        /*List<Type> list = new ArrayList<>();
        int count = lists.size();
        int allpage;
        if (count==15){
            allpage = 1;
        }else{
            allpage = count / 15 + 1;
        }
        int pagenum = 15;
        int nowpage = 1;
        for(int i = 0;i < 15;i++){
            list.add(lists.get(i));
        }*/
        model.addAttribute("types",lists);
       /* model.addAttribute("allpage",allpage);
        model.addAttribute("nowpage",nowpage);*/
        return "admin/types";
    }

    @RequestMapping("/Tags")
    public String findAllTags(Model model){
        model.addAttribute("tags",tagService.findAllTag());
        return "admin/tags";
    }
}
