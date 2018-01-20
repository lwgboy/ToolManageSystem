package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.CommentDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.entity.Comment;
import site.yananart.entity.Tool;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

public class ChangeCommentDetailAction {
    private String commentContent;

    private void renovate(String id) throws SQLException {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Tool tool=GetDAO.getToolDAO().getToolById(id);
        session.put("tool",tool);
        return;
    }

    private void getComment() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        CommentDAO commentDAO=GetDAO.getCommentDAO();
        ToolDAO toolDAO=GetDAO.getToolDAO();
        Tool tool = (Tool) session.get("tool");
        ArrayList<Comment> comments=commentDAO.getCommentByToolId(tool.getToolId());
        ArrayList<Comment> commentArrayList=new ArrayList<>();
        if(comments!=null){
            comments.forEach(x->{
                if(x.isComment()) commentArrayList.add(x);
            });
        }
        session.put("comments",commentArrayList);
    }

    public String insertComment() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        CommentDAO commentDAO= GetDAO.getCommentDAO();
        Comment comment= (Comment)session.get("mycomment");
        comment.setComment(true);
        comment.setCommentContent(commentContent);
        comment.setCommendTime(new Timestamp(System.currentTimeMillis()));
        commentDAO.insertComment(comment.getToolId(),comment.getUserId(),commentContent);
        session.put("mycomment",comment);
        renovate(comment.getToolId());
        getComment();
        return "success";
    }

    public String markStart() throws SQLException {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Comment comment= (Comment) session.get("mycomment");
        GetDAO.getCommentDAO().makeStar(comment.getToolId(),comment.getUserId(),!comment.isStar());
        comment.setStar(!comment.isStar());
        session.put("mycomment",comment);
        renovate(comment.getToolId());
        return "success";
    }

    public String goBack(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        Tool tool= (Tool) session.get("tool");
        ArrayList<Tool> tools= (ArrayList<Tool>) session.get("reslut");
        for (int i = 0; i < tools.size(); i++) {
            if(tools.get(i).getToolId().equals(tool.getToolId())){
                tools.set(i,tool);
                break;
            }
        }
        session.remove("url");
        session.remove("tool");
        return "success";
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
