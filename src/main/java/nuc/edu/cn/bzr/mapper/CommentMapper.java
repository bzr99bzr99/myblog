package nuc.edu.cn.bzr.mapper;

import nuc.edu.cn.bzr.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    public int insertComment(Comment comment);
    public int deleteCommentByBlogId(int blogId);
}
