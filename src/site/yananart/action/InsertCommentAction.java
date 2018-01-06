package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.dao.CommentDAO;
import site.yananart.entity.Comment;
import site.yananart.entity.User;

import java.sql.Timestamp;
import java.util.Map;

public class InsertCommentAction {
    private String commentContent;

    public String execute(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        CommentDAO commentDAO=new CommentDAO();
        Comment comment= (Comment)session.get("mycomment");
        comment.setComment(true);
        comment.setCommentContent(commentContent);
        comment.setCommendTime(new Timestamp(System.currentTimeMillis()));
        commentDAO.insertComment(comment.getToolId(),comment.getUserId(),commentContent);
        session.put("mycomment",comment);
        return "success";
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
