package nuc.edu.cn.bzr.service.serviceimpl;

import nuc.edu.cn.bzr.mapper.TagMapper;
import nuc.edu.cn.bzr.model.Blog;
import nuc.edu.cn.bzr.model.Tag;
import nuc.edu.cn.bzr.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> findAllTag() {
        return tagMapper.findAllTag();
    }

    @Override
    public Tag findTagByName(String tagName) {
        return tagMapper.findTagByName(tagName);
    }

    @Override
    public int insertTag(Tag tag) {
        return tagMapper.insertTag(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public int getBlogNumByTagId(int tagId) {
        return tagMapper.getBlogNumByTagId(tagId);
    }

    @Override
    public List<Blog> findBlogBytagId(Tag tag) {
        return tagMapper.findBlogByTagId(tag);
    }

}
