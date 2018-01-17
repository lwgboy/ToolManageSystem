package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.dao.UserDAO;
import site.yananart.entity.Tool;
import site.yananart.entity.User;

import java.util.ArrayList;
import java.util.Map;

public class LoginAction{
    private String userId;
    private String password;
    private String userType;

    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        UserDAO userDAO= GetDAO.getUserDAO();
        User user=userDAO.getUserById(userId);
        if(user!=null){
            if(user.getUserPwd().equals(password)){
                if(userType.equals("admin")){
                    if(user.getUserType()==0){
                        session.put("LoginStatus","此账户不是管理员账户");
                        return "error";
                    }
                    session.remove("LoginStatus");
                    session.put("user",user);
                    ToolDAO toolDAO=GetDAO.getToolDAO();
                    ArrayList<Tool> tools=toolDAO.getToolListByType(user.getManageType());
                    session.put("tools",tools);
                    return "admin";
                }
                session.remove("LoginStatus");
                session.put("user",user);
                return "success";
            }
            session.put("LoginStatus","密码错误");
            return "error";
        }
        session.put("LoginStatus","无此用户");
        return "error";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
