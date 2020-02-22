package nuc.edu.cn.bzr.model;

import java.util.Date;
import java.util.List;

public class Comment {
    private int commentId;
    private String commentName;
    private String commentQQ;
    private String commentContent;
    private Date commentTime;
    private String commentTo;
    private int parent;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentName='" + commentName + '\'' +
                ", commentQQ='" + commentQQ + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentTime=" + commentTime +
                ", commentTo='" + commentTo + '\'' +
                ", parent=" + parent +
                ", commentList=" + commentList +
                '}';
    }

    public String getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(String commentTo) {
        this.commentTo = commentTo;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentQQ() {
        return commentQQ;
    }

    public void setCommentQQ(String commentQQ) {
        this.commentQQ = commentQQ;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
