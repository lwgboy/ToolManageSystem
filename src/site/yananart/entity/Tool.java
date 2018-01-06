package site.yananart.entity;

import java.sql.Timestamp;

public class Tool {
    private String toolId;
    private String toolName;
    private String toolVersion;
    private int toolType;
    private Timestamp uploadTime;
    private String uploadUserId;
    private String toolDescribe;
    private String toolTag;
    private String toolUrl;
    private int downloadNumber;
    private int starNumber;
    private int commentNumber;

    public Tool(String toolId) {
        this.toolId = toolId;
    }

    public Tool(String toolName, String toolVersion, int toolType, String uploadUserId, String toolDescribe, String toolTag) {
        this.toolName = toolName;
        this.toolVersion = toolVersion;
        this.toolType = toolType;
        this.uploadUserId = uploadUserId;
        this.toolDescribe = toolDescribe;
        this.toolTag = toolTag;
    }

    public Tool(String toolId, String toolName, String toolVersion, int toolType, Timestamp uploadTime, String uploadUserId, String toolDescribe, String toolTag, String toolUrl, int downloadNumber, int starNumber, int commentNumber) {
        this.toolId = toolId;
        this.toolName = toolName;
        this.toolVersion = toolVersion;
        this.toolType = toolType;
        this.uploadTime = uploadTime;
        this.uploadUserId = uploadUserId;
        this.toolDescribe = toolDescribe;
        this.toolTag = toolTag;
        this.toolUrl = toolUrl;
        this.downloadNumber = downloadNumber;
        this.starNumber = starNumber;
        this.commentNumber = commentNumber;
    }

    public void copyFrom(Tool tool){
        this.toolId = tool.getToolId();
        this.toolName = tool.getToolName();
        this.toolVersion = tool.getToolVersion();
        this.toolType = tool.getToolType();
        this.uploadTime = tool.getUploadTime();
        this.uploadUserId = tool.getUploadUserId();
        this.toolDescribe = tool.getToolDescribe();
        this.toolTag = tool.getToolTag();
        this.toolUrl = tool.getToolUrl();
        this.downloadNumber = tool.getDownloadNumber();
        this.starNumber = tool.getStarNumber();
        this.commentNumber = tool.getCommentNumber();
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public void setToolVersion(String toolVersion) {
        this.toolVersion = toolVersion;
    }

    public int getToolType() {
        return toolType;
    }

    public void setToolType(int toolType) {
        this.toolType = toolType;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(String uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public String getToolDescribe() {
        return toolDescribe;
    }

    public void setToolDescribe(String toolDescribe) {
        this.toolDescribe = toolDescribe;
    }

    public String getToolTag() {
        return toolTag;
    }

    public void setToolTag(String toolTag) {
        this.toolTag = toolTag;
    }

    public String getToolUrl() {
        return toolUrl;
    }

    public void setToolUrl(String toolUrl) {
        this.toolUrl = toolUrl;
    }

    public int getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }
}
