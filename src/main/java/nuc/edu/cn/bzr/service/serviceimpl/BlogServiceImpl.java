package nuc.edu.cn.bzr.service.serviceimpl;

import nuc.edu.cn.bzr.mapper.BlogAndOther;
import nuc.edu.cn.bzr.mapper.BlogMapper;
import nuc.edu.cn.bzr.mapper.CommentMapper;
import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Page;
import nuc.edu.cn.bzr.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogAndOther blogAndOther;
    @Autowired
    CommentMapper commentMapper;
    /**
     * 在管理员博客管理界面查询所有博客，只包含部分所需信息
     *
     * @return
     */
    @Override
    public List<Blog> findAllBlogsAtBlogs(Page page) {
        return blogMapper.findAllBlogAtBlogs(page);
    }

    @Override
    public List<Blog> findBlogAtBlogs(Blog blog) {
        return blogMapper.findBlogByBlogNameAndBlogType(blog);
    }

    @Override
    public int deleteBlog(int blogId) {
        blogAndOther.deleteBlogAndTypeByBlogId(blogId);
        blogAndOther.deleteBlogAndTagByBlogId(blogId);
        blogAndOther.deleteBlogAndCommentByBlogId(blogId);
        commentMapper.deleteCommentByBlogId(blogId);
        return blogMapper.deleteBlog(blogId);
    }

    @Override
    public Blog selectBlogByBlogId(int blogId) {
        return blogMapper.selectBlogByBlogId(blogId);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public int updateTypeByBlogId(Blog blog) {
        return blogAndOther.updateTypeByBlogId(blog);
    }

    @Override
    public int deleteTagByBlogId(int blogId) {
        return blogAndOther.deleteTagsByBlogId(blogId);
    }

    @Override
    public int insertTagByBlogId(Blog blog) {
        return blogAndOther.insertTagByBlogId(blog);
    }

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

    @Override
    public int insertTypeByBlogId(Blog blog) {
        return blogAndOther.insertTypeByBlogId(blog);
    }

    @Override
    public int blogcount() {
        return blogMapper.blogcount();
    }

    @Override
    public int findCountByBlogNameAndBlogType(Blog blog) {
        return blogMapper.findCountByBlogNameAndBlogType(blog);
    }

    @Override
    public List<Blog> findBlogs(Blog blog) {
        return blogMapper.findBlogs(blog);
    }

    @Override
    public int getBlogCount() {
        return blogMapper.getBlogCount();
    }

    @Override
    public Blog selectBlog(int blogId) {
        return blogMapper.selectBlog(blogId);
    }

    @Override
    public int lookBlog(Blog blog) {
        return blogMapper.lookBlog(blog);
    }

    @Override
    public int likeBlog(Blog blog) {
        return blogMapper.likeBlog(blog);
    }

    @Override
    public List<Blog> archivesBlog() {
        return blogMapper.archivesBlog();
    }

    @Override
    public int archivesCount() {
        return blogMapper.archivesCount();
    }

    @Override
    public List<Blog> AllSearch(Blog blog) {
        return blogMapper.AllSearch(blog);
    }

    @Override
    public int AllSearchCount(String query) {
        return blogMapper.AllSearchCount(query);
    }
}
