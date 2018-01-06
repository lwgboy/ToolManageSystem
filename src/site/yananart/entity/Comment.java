package site.yananart.entity;

import java.sql.*;

public class Comment {
    private String toolId;
    private String userId;
    private boolean isStar;
    private boolean isComment;
    private String commentContent;
    private Timestamp commendTime;

    public Comment(String toolId, String userId, boolean isStar, boolean isComment, String commentContent, Timestamp commendTime) {
        this.toolId = toolId;
        this.userId = userId;
        this.isStar = isStar;
        this.isComment = isComment;
        this.commentContent = commentContent;
        this.commendTime = commendTime;
    }

    public Comment(String toolId, String userId) {
        this.toolId = toolId;
        this.userId = userId;
        this.isStar = false;
        this.isComment = false;
        this.commentContent = null;
        this.commendTime = null;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isStar() {
        return isStar;
    }

    public void setStar(boolean star) {
        isStar = star;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommendTime() {
        return commendTime;
    }

    public void setCommendTime(Timestamp commendTime) {
        this.commendTime = commendTime;
    }
}