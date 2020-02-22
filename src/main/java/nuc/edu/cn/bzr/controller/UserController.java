package nuc.edu.cn.bzr.controller;

import nuc.edu.cn.bzr.model.*;
import nuc.edu.cn.bzr.service.BlogService;
import nuc.edu.cn.bzr.service.CommentService;
import nuc.edu.cn.bzr.service.TagService;
import nuc.edu.cn.bzr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    CommentService commentService;

    @RequestMapping("/")
    public String toIndex(Model model) {
        Blog blog = new Blog();
        blog.setNowcount(0);
        model.addAttribute("blogs", blogService.findBlogs(blog));
        model.addAttribute("blogcount", blogService.getBlogCount());
        int i = 0;
        List<Type> typeList = typeService.findAllType();
        for (Type type : typeList) {
            if (i < 7) {
                i++;
                type.setBlogNum(typeService.getBlogNumByTypeId(type.getTypeId()));
            } else {
                break;
            }
        }
        i = 0;
        model.addAttribute("types", typeList);
        List<Tag> tagList = tagService.findAllTag();
        for (Tag tag : tagList) {
            if (i < 15) {
                i++;
                tag.setBlogNum(tagService.getBlogNumByTagId(tag.getTagId()));
            } else {
                break;
            }
        }
        model.addAttribute("tags", tagList);
        return "index";
    }

    /**
     * ajax点赞喜欢加一
     *
     * @param blog
     * @return
     */
    @RequestMapping("/like")
    @ResponseBody
    public int LikeBlog(Blog blog) {
        blog.setWell(blog.getWell() + 1);
        return blogService.likeBlog(blog);
    }

    /**
     * 主页ajax查询更多博客
     *
     * @param morecount
     * @return
     */
    @RequestMapping("/Blogfindmore")
    @ResponseBody
    public List<Blog> Blogfindmore(int morecount) {
        Blog blog = new Blog();
        blog.setNowcount(morecount * 5);
        return blogService.findBlogs(blog);
    }

    /**
     * type界面查询type相关的博客五个
     *
     * @param type
     * @return
     */
    @RequestMapping("/searchtype")
    @ResponseBody
    public List<Blog> searchType(Type type) {
        return typeService.findBlogByTypeId(type);
    }

    /**
     * ajax标签界面查询相关tag
     *
     * @param tag
     * @return
     */
    @RequestMapping("/searchtag")
    @ResponseBody
    public List<Blog> searchTag(Tag tag) {
        return tagService.findBlogBytagId(tag);
    }


    /**
     * ajax分类界面查询更多
     *
     * @param type
     * @param morecount
     * @return
     */
    @RequestMapping("/findMoreType")
    @ResponseBody
    public List<Blog> searchTypeMore(Type type, int morecount) {
        if (type.getTypeId() == 0) {
            Blog blog = new Blog();
            blog.setNowcount(morecount * 5);
            return blogService.findBlogs(blog);
        }
        type.setNowcount(morecount * 5);
        return typeService.findBlogByTypeId(type);
    }

    @RequestMapping("/findMoreTag")
    @ResponseBody
    public List<Blog> searchTagMore(Tag tag, int morecount) {
        if (tag.getTagId() == 0) {
            Blog blog = new Blog();
            blog.setNowcount(morecount * 5);
            return blogService.findBlogs(blog);
        }
        tag.setNowcount(morecount * 5);
        return tagService.findBlogBytagId(tag);
    }

    @RequestMapping("/comment")
    @ResponseBody
    public List<Comment> comment(Comment comment,Blog blog) {
        comment.setCommentTime(new Date());
        commentService.insertComment(comment);
        blog.setCommentId(comment.getCommentId());
        commentService.insertCommentByBlogId(blog);
        List<Comment> commentList = commentService.findCommentsByBlogId(blog.getBlogId());
        Comment(commentList);
        return commentList;
    }

    public void Comment(List<Comment> comments){
        for (int i = 0;i < comments.size();i++){
            if (comments.get(i).getParent()==-1){
                List<Comment> list = new ArrayList<>();
                comments.get(i).setCommentList(list);
            } else{
                for (int j =0;j < comments.size();j++){
                    if (comments.get(i).getParent()==comments.get(j).getCommentId()){
                        comments.get(j).getCommentList().add(comments.get(i));
                        break;
                    }
                }
                comments.remove(i);
                i--;
            }
        }
    }
    @RequestMapping("/findMoreSearch")
    @ResponseBody
    public List<Blog> findMoreSearch(Blog blog ,int morecount){
        blog.setNowcount(morecount*5);
        System.out.println(blog);
        return blogService.AllSearch(blog);
    }
}
