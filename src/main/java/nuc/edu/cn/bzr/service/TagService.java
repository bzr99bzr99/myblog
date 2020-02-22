package nuc.edu.cn.bzr.service;

import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> findAllTag();
    public Tag findTagByName(String tagName);
    public int insertTag(Tag tag);
    public int updateTag(Tag tag);
    public int getBlogNumByTagId(int tagId);
    public List<Blog> findBlogBytagId(Tag tag);
}
