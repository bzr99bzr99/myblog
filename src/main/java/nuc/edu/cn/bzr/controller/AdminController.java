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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    BlogService blogService;

    /**
     * 博客输入文本检测
     *
     * @param blog
     * @return
     */
    @RequestMapping("/input")
    @ResponseBody
    public Blog input(Blog blog) {
        return blog;
    }

    /**
     * ajax查询类型
     *
     * @param typeName
     * @return
     */
    @RequestMapping("/findType")
    @ResponseBody
    public Type findType(String typeName) {
        return typeService.findType(typeName);
    }

    /**
     * ajax增加博客类型
     *
     * @param type
     * @return
     */
    @RequestMapping("insertType")
    @ResponseBody
    public Type insertType(Type type) {
        return typeService.insertType(type);
    }

    /**
     * ajax查询全部
     *
     * @return
     */
    @RequestMapping("/findAllType")
    @ResponseBody
    public List<Type> findAllTypes() {
        return typeService.findAllType();
    }

    /**
     * ajax删除Type
     *
     * @param typeId
     * @return
     */
    @RequestMapping("/deleteType")
    @ResponseBody
    public int deleteType(int typeId) {
        return typeService.deleteType(typeId);
    }

    /**
     * ajax修改type
     *
     * @param type
     * @return
     */
    @RequestMapping("/updateType")
    @ResponseBody
    public int deleteType(Type type) {
        return typeService.updateType(type);
    }

    /**
     * ajax根据tagName查询一个标签
     *
     * @param tagName
     * @return
     */
    @RequestMapping("/findTagByName")
    @ResponseBody
    public Tag findTagByName(String tagName) {
        return tagService.findTagByName(tagName);
    }

    /**
     * ajax查询全部标签
     *
     * @param
     * @return
     */
    @RequestMapping("/findAllTag")
    @ResponseBody
    public List<Tag> findAllTag() {
        return tagService.findAllTag();
    }

    /**
     * ajax增加一个标签
     *
     * @param tag
     * @return
     */
    @PostMapping("/insertTag")
    @ResponseBody
    public int insertTag(Tag tag) {
        return tagService.insertTag(tag);
    }

    /**
     * ajax修改一个tag
     *
     * @param tag
     * @return
     */
    @RequestMapping("/updateTag")
    @ResponseBody
    public int upadteTag(Tag tag) {
        return tagService.updateTag(tag);
    }

    /**
     * 管理员管理博客页面ajax查询博客
     * blogName：模糊查询
     * blogType：精确查询所有
     * blogName，blogType：查询所有符合条件的
     * 动态sql查询
     *
     * @param blog
     * @return
     */
    @RequestMapping("/findBlogByTitleAndType")
    @ResponseBody
    public List<Blog> findBlogByTitleAndType(Blog blog) {
        Page page = new Page();
        page.setNowcount(0);
        page.setNowpage(0);
        page.setPagecount(14);
        blog.setPage(page);
        page.setCount(blogService.findCountByBlogNameAndBlogType(blog));
        if (page.getCount()%page.getPagecount()==0){
            page.setAllpage(page.getCount()/page.getPagecount());
        }else{
            page.setAllpage(page.getCount()/page.getPagecount()+1);
        }
        blog.setNowcount(page.getNowcount());
        blog.setPage(page);
        return blogService.findBlogAtBlogs(blog);
    }

    /**
     * 在博客管理页面用ajax查询所有的博客
     *
     * @return
     */
    @RequestMapping("/findAllBlogAtBlogs")
    @ResponseBody
    public List<Blog> findAllBlogAtBlogs() {
        Page page = new Page();
        page.setNowpage(0);
        page.setPagecount(14);
        return blogService.findAllBlogsAtBlogs(page);
    }

    /**
     * 博客管理页面ajax删除博客
     *
     * @param blogId
     * @return
     */
    @RequestMapping("/deleteBlog")
    @ResponseBody
    public int deleteBlog(int blogId) {
        return blogService.deleteBlog(blogId);
    }

    /**
     * 博客管理页面编辑单个博客信息时返回该博客所有信息并跳转至发布页面，发布页面内含隐藏输入框，如果隐藏输入框内含博客信息ID，则为修改方式，没有信息则为新增方式
     *
     * @param blogId
     * @return
     */
    @RequestMapping("/selectBlogByBlogId")
    public String selectBlogByBlogId(int blogId, Model model,Page page) {
        String inputTags = "";
        Blog blog = blogService.selectBlogByBlogId(blogId);
        List<Tag> tags = tagService.findAllTag();
        List<Type> types = typeService.findAllType();
        for (int i = 0, j = 0; i < tags.size(); i++) {
            if (j >= blog.getTags().size()) {
                break;
            }
            if (blog.getTags().get(j).getTagId() == tags.get(i).getTagId()) {
                if (j == 0) {
                    inputTags = inputTags + blog.getTags().get(j).getTagId();
                } else {
                    inputTags = inputTags + "," + blog.getTags().get(j).getTagId();
                }
                tags.get(i).setActive(1);
                j++;
            }
        }
        model.addAttribute("page",page);
        model.addAttribute("blog", blog);
        model.addAttribute("tags", tags);
        model.addAttribute("types", types);
        model.addAttribute("inputTags", inputTags);
        return "admin/input";
    }

    /**
     * type根据blogId修改相应的blogandtypetypeId
     * tag讲blogId删除所有再添加所有
     * @param blog
     * @param tag
     * @return
     */
    @RequestMapping("/updateBlog")
    public String updateBlog(Blog blog, String tag, Model model) {
        Page page = new Page();
        page.setNowpage(0);
        page.setCount(blogService.blogcount());
        page.setPagecount(14);
        page.setNowcount(page.getPagecount()*page.getNowpage());
        page.setCount(page.getCount()+1);
        if (page.getCount()%page.getPagecount()==0){
            page.setAllpage(page.getCount()/page.getPagecount());
        }else{
            page.setAllpage(page.getCount()/page.getPagecount()+1);
        }
        if (blog.getBlogId()!=0){
            Date date = new Date();
            String[] split = tag.split(",");
            blog.setUpdateTime(date);
            List<Tag> tags = new ArrayList<>();
            for (int i = 0;i < split.length;i++){
                Tag tag1 = new Tag();
                tag1.setTagId(Integer.parseInt(split[i]));
                tags.add(tag1);
            }
            blog.setTags(tags);
            blogService.deleteTagByBlogId(blog.getBlogId());
            blogService.insertTagByBlogId(blog);
            blogService.updateTypeByBlogId(blog);
            blogService.updateBlog(blog);
            model.addAttribute("message","博客修改成功");
        }else{
            String[] split = tag.split(",");
            List<Tag> tags = new ArrayList<>();
            for (int i = 0;i < split.length;i++){
                Tag tag1 = new Tag();
                tag1.setTagId(Integer.parseInt(split[i]));
                tags.add(tag1);
            }
            blog.setTags(tags);
            blog.setUpdateTime(new Date());
            blog.setCreateTime(new Date());
            blog.setIspull(1);
            blog.setPictureId(1);
            blog.setView(0);
            blog.setWell(0);
            blogService.insertBlog(blog);
            blogService.insertTagByBlogId(blog);
            blogService.insertTypeByBlogId(blog);
            model.addAttribute("message","博客添加成功");
        }
        model.addAttribute("page",page);
        model.addAttribute("blogs",blogService.findAllBlogsAtBlogs(page));
        model.addAttribute("types",typeService.findAllType());
        return "admin/blogs";
    }

    /**
     * ajax实现下一页
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/nextpage")
    @ResponseBody
    public List<Blog> nextPage(Page page,Model model,Blog blog){

        if (blog.getBlogId()==1){
            page.setNowcount(page.getPagecount()*page.getNowpage());
            return blogService.findAllBlogsAtBlogs(page);
        } else {
           page.setNowcount(page.getPagecount()*page.getNowpage());
           blog.setNowcount(page.getNowcount());
           return blogService.findBlogAtBlogs(blog);
       }
    }

    /**
     * ajax实现上一页
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/prepage")
    @ResponseBody
    public List<Blog> prePage(Page page,Model model,Blog blog){
        page.setNowpage(page.getNowpage()-2);
        page.setNowcount(page.getPagecount()*page.getNowpage());
        if (blog.getBlogId()==1){
            return blogService.findAllBlogsAtBlogs(page);
        } else {
            blog.setNowcount(page.getNowcount());
            return blogService.findBlogAtBlogs(blog);
        }
    }

    /**
     * ajax查询页码信息
     * @param attribute
     * @return
     */
    @RequestMapping("/getPage")
    @ResponseBody
    public Page getPage(Blog blog,int attribute) {
        if (attribute==1){
            Page page = new Page();
            page.setNowpage(0);
            page.setPagecount(14);
            page.setCount(blogService.blogcount());
            if (page.getCount()%page.getPagecount()==0){
                page.setAllpage(page.getCount()/page.getPagecount());
            }else{
                page.setAllpage(page.getCount()/page.getPagecount()+1);
            }
            page.setNowcount(0);
            return page;
        }else{
            Page page = new Page();
            page.setNowpage(0);
            page.setPagecount(14);
            page.setCount(blogService.findCountByBlogNameAndBlogType(blog));
            if (page.getCount()%page.getPagecount()==0){
                page.setAllpage(page.getCount()/page.getPagecount());
            }else{
                page.setAllpage(page.getCount()/page.getPagecount()+1);
            }
            page.setNowcount(page.getNowpage()*page.getPagecount());
            return page;
        }
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
