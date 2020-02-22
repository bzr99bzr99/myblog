package nuc.edu.cn.bzr.model;

import java.util.Date;
import java.util.List;

public class Blog {
    private int blogId;
    private String content;
    private String title;
    private String symbol;
    private int view;
    private int well;
    private int ispull;
    private int pictureId;
    private List<Picture> pictures;
    private String blogDescribe;
    private Type type;
    private Page page;
    private int nowcount;
    private int commentId;

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", symbol='" + symbol + '\'' +
                ", view=" + view +
                ", well=" + well +
                ", ispull=" + ispull +
                ", pictureId=" + pictureId +
                ", pictures=" + pictures +
                ", blogDescribe='" + blogDescribe + '\'' +
                ", type=" + type +
                ", page=" + page +
                ", nowcount=" + nowcount +
                ", commentId=" + commentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getNowcount() {
        return nowcount;
    }

    public void setNowcount(int nowcount) {
        this.nowcount = nowcount;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(String blogDescribe) {
        this.blogDescribe = blogDescribe;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int picturId) {
        this.pictureId = picturId;
    }

    private Date createTime;
    private Date updateTime;
    private List<Tag> tags;
    private List<Comment> comments;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getWell() {
        return well;
    }

    public void setWell(int well) {
        this.well = well;
    }

    public int getIspull() {
        return ispull;
    }

    public void setIspull(int ispull) {
        this.ispull = ispull;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
