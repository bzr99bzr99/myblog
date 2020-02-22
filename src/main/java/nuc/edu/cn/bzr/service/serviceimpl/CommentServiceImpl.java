package nuc.edu.cn.bzr.service.serviceimpl;

import nuc.edu.cn.bzr.mapper.BlogAndOther;
import nuc.edu.cn.bzr.mapper.CommentMapper;
import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Comment;
import nuc.edu.cn.bzr.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    BlogAndOther blogAndOther;
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentsByBlogId(int blogId) {
        return blogAndOther.findCommentsByBlogId(blogId);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int insertCommentByBlogId(Blog blog) {
        return blogAndOther.insertCommentByBlogId(blog);
    }
}
