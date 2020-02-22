package nuc.edu.cn.bzr.service;


import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Page;

import java.util.List;

public interface BlogService {
    public List<Blog> findAllBlogsAtBlogs(Page page);
    public List<Blog> findBlogAtBlogs(Blog blog);
    public int deleteBlog(int blogId);
    public Blog selectBlogByBlogId(int blogId);
    public int updateBlog(Blog blog);
    public int updateTypeByBlogId(Blog blog);
    public int deleteTagByBlogId(int blogId);
    public int insertTagByBlogId(Blog blog);
    public int insertBlog(Blog blog);
    public int insertTypeByBlogId(Blog blog);
    public int blogcount();
    public int findCountByBlogNameAndBlogType(Blog blog);
    public List<Blog> findBlogs(Blog blog);
    public int getBlogCount();
    public Blog selectBlog(int blogId);
    public int lookBlog(Blog blog);
    public int likeBlog(Blog blog);
    public List<Blog> archivesBlog();
    public int archivesCount();
    public List<Blog> AllSearch(Blog blog);
    public int AllSearchCount(String query);
}
