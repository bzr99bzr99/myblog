package nuc.edu.cn.bzr.mapper;

import jdk.internal.dynalink.linker.LinkerServices;
import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogAndOther {
    public int updateTypeByBlogId(Blog blog);
    public int deleteTagsByBlogId(int blogId);
    public int insertTagByBlogId(Blog blog);
    public int insertTypeByBlogId(Blog blog);
    public List<Comment> findCommentsByBlogId(int blogId);
    public int insertCommentByBlogId(Blog blog);
    public int deleteBlogAndTagByBlogId(int blogId);
    public int deleteBlogAndCommentByBlogId(int blogId);
    public int deleteBlogAndTypeByBlogId(int blogId);
}
