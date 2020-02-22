package nuc.edu.cn.bzr.mapper;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    public List<Tag> findAllTag();
    public Tag findTagByName(String tagName);
    public int insertTag(Tag tag);
    public int updateTag(Tag tag);
    public int getBlogNumByTagId(int tagId);
    public List<Blog> findBlogByTagId(Tag tag);
}
