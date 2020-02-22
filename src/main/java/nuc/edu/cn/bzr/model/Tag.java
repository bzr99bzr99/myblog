package nuc.edu.cn.bzr.model;

import java.util.List;

public class Tag {
    private int tagId;
    private String tagName;
    private List<Blog> blogs;
    private int active = 0;
    private int BlogNum;
    private int nowcount;

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", blogs=" + blogs +
                ", active=" + active +
                ", BlogNum=" + BlogNum +
                ", nowcount=" + nowcount +
                '}';
    }

    public int getNowcount() {
        return nowcount;
    }

    public void setNowcount(int nowcount) {
        this.nowcount = nowcount;
    }

    public int getBlogNum() {
        return BlogNum;
    }

    public void setBlogNum(int blogNum) {
        BlogNum = blogNum;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
