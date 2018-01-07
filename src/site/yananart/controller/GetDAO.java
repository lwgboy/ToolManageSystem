package site.yananart.controller;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.dao.CommentDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.dao.UserDAO;

import java.util.Map;

public class GetDAO {
    public static UserDAO getUserDAO(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserDAO userDAO= (UserDAO) session.get("userDAO");
        if(userDAO==null){
            userDAO=new UserDAO();
            session.put("userDAO",userDAO);
        }
        return userDAO;
    }

    public static ToolDAO getToolDAO(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        ToolDAO toolDAO= (ToolDAO) session.get("toolDAO");
        if(toolDAO==null){
            toolDAO=new ToolDAO();
            session.put("toolDAO",toolDAO);
        }
        return toolDAO;
    }

    public static CommentDAO getCommentDAO(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        CommentDAO commentDAO= (CommentDAO) session.get("commentDAO");
        if(commentDAO==null){
            commentDAO=new CommentDAO();
            session.put("commentDAO",commentDAO);
        }
        return commentDAO;
    }
}
