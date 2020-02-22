package nuc.edu.cn.bzr.service;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> findCommentsByBlogId(int blogId);
    public int insertComment(Comment comment);
    public int insertCommentByBlogId(Blog blog);
}
