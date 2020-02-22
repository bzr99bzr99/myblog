package nuc.edu.cn.bzr.controller;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Comment;
import nuc.edu.cn.bzr.model.Tag;
import nuc.edu.cn.bzr.model.Type;
import nuc.edu.cn.bzr.service.BlogService;
import nuc.edu.cn.bzr.service.CommentService;
import nuc.edu.cn.bzr.service.TagService;
import nuc.edu.cn.bzr.service.TypeService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/to")
@Controller
public class Topage {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    CommentService commentService;

    @RequestMapping("/blog")
    public String toBlog(int blogId, Model model) {
        Parser parser = Parser.builder().build();
        Blog blog = blogService.selectBlog(blogId);
        blog.setView(blog.getView() + 1);
        blogService.lookBlog(blog);
        Node node = parser.parse(blog.getContent());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        blog.setContent(renderer.render(node));
        model.addAttribute("blog", blog);
        //评论
        List<Comment> commentList = commentService.findCommentsByBlogId(blogId);
        Comment(commentList);
        model.addAttribute("comments", commentList);
        return "blog";
    }

    public void Comment(List<Comment> comments) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getParent() == -1) {
                List<Comment> list = new ArrayList<>();
                comments.get(i).setCommentList(list);
            } else {
                for (int j = 0; j < comments.size(); j++) {
                    if (comments.get(i).getParent() == comments.get(j).getCommentId()) {
                        comments.get(j).getCommentList().add(comments.get(i));
                        break;
                    }
                }
                comments.remove(i);
                i--;
            }
        }
       /* for(int i = 0;i < comments.size();i++){
            if (comments.get(i).getParent()!=-1){

            }
        }*/
    }

    @RequestMapping("/about")
    public String toAbout() {
        return "about";
    }

    @RequestMapping("/archives")
    public String toArchives(Model model) {
        model.addAttribute("archivesCount", blogService.archivesCount());
        List<Blog> blogs = blogService.archivesBlog();
        Map<Integer, List<Blog>> map = new HashMap<>();
        for (Blog blog : blogs) {
            if (map.get(blog.getCreateTime().getYear() - 100) != null) {
                map.get(blog.getCreateTime().getYear() - 100).add(blog);
            } else {
                List<Blog> blogs1 = new ArrayList<>();
                blogs1.add(blog);
                map.put(blog.getCreateTime().getYear() - 100, blogs1);
            }
        }
        model.addAttribute("blogs", map);
        return "archives";
    }

    @RequestMapping("/tags")
    public String toTags(Model model, Tag mtag) {
        List<Tag> tagList = tagService.findAllTag();
        for (Tag tag : tagList) {
            tag.setBlogNum(tagService.getBlogNumByTagId(tag.getTagId()));
        }
        model.addAttribute("tagNum", tagList.size());
        model.addAttribute("tags", tagList);
        if (mtag.getTagId() != 0) {
            model.addAttribute("blogs", tagService.findBlogBytagId(mtag));
            model.addAttribute("tagId", mtag.getTagId());
            return "tags";
        }
        model.addAttribute("tagId", mtag.getTagId());
        Blog blog = new Blog();
        blog.setNowcount(0);
        model.addAttribute("blogs", blogService.findBlogs(blog));
        return "tags";
    }

    @RequestMapping("/types")
    public String toTypes(Model model, Type mtype) {
        List<Type> typeList = typeService.findAllType();
        for (Type type : typeList) {
            type.setBlogNum(typeService.getBlogNumByTypeId(type.getTypeId()));
        }
        model.addAttribute("typeNum", typeList.size());
        model.addAttribute("types", typeList);
        if (mtype.getTypeId() != 0) {
            model.addAttribute("blogs", typeService.findBlogByTypeId(mtype));
            model.addAttribute("activeId", mtype.getTypeId());
            return "types";
        }
        model.addAttribute("activeId", mtype.getTypeId());
        Blog blog = new Blog();
        blog.setNowcount(0);
        model.addAttribute("blogs", blogService.findBlogs(blog));
        return "types";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/search")
    public String toSearch(Blog blog,Model model) {
        model.addAttribute("blogs",blogService.AllSearch(blog));
        model.addAttribute("searchcount",blogService.AllSearchCount(blog.getTitle()));
        model.addAttribute("query",blog.getTitle());
        return "search";
    }
}
