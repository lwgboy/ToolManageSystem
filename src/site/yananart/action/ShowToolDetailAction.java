package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.CommentDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.dao.UserDAO;
import site.yananart.entity.Comment;
import site.yananart.entity.Tool;
import site.yananart.entity.User;

import java.util.ArrayList;
import java.util.Map;

public class ShowToolDetailAction {
    private String toolId;

    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String realpath = ServletActionContext.getServletContext().getRealPath("/tool");
        User user= (User) session.get("user");
        Comment comment;
        ToolDAO toolDAO= GetDAO.getToolDAO();
        UserDAO userDAO= GetDAO.getUserDAO();
        CommentDAO commentDAO=GetDAO.getCommentDAO();
        Tool tool = toolDAO.getToolById(toolId);
        if(!commentDAO.isHaveComment(tool.getToolId(),user.getUserId())){
            commentDAO.createComment(tool.getToolId(),user.getUserId());
            comment=new Comment(tool.getToolId(),user.getUserId());
        }else {
            comment=commentDAO.getCommentById(tool.getToolId(),user.getUserId());
        }
        session.put("mycomment",comment);
        session.put("tool",tool);
        ArrayList<Comment> comments=commentDAO.getCommentByToolId(tool.getToolId());
        ArrayList<Comment> commentArrayList=new ArrayList<>();
        if(comments!=null){
            comments.forEach(x->{
                if(x.isComment()) commentArrayList.add(x);
            });
        }
        session.put("comments",commentArrayList);
        session.put("path",tool.getToolUrl());
        return "success";
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }
}
