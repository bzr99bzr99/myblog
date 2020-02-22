package nuc.edu.cn.bzr.model;

import java.util.List;

public class Type {
    private int typeId;
    private String typeName;
    private List<Blog> blogs;
    private int BlogNum;
    private int nowcount;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", blogs=" + blogs +
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


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
