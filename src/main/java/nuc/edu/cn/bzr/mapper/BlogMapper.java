package nuc.edu.cn.bzr.mapper;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    /**
     * 查询所有的博客（id,title,type,updateTime）blogs.html
     * @return
     */
    public List<Blog> findAllBlogAtBlogs(Page page);
    public List<Blog> findBlogByBlogNameAndBlogType(Blog blog);
    public int deleteBlog(int blogId);
    public Blog selectBlogByBlogId(int blogId);
    public int updateBlog(Blog blog);
    public int insertBlog(Blog blog);
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
