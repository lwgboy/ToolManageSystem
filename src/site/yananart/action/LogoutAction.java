package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.UserDAO;

import java.util.Map;

public class LogoutAction {
    public String logout(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        GetDAO.getUserDAO().closeConnect();
        GetDAO.getToolDAO().closeConnect();
        GetDAO.getCommentDAO().closeConnect();
        session.clear();
        return "success";
    }
}
