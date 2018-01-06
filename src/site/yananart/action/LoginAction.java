package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.dao.UserDAO;
import site.yananart.entity.User;

import java.util.Map;

public class LoginAction{
    private String userId;
    private String password;

    public String execute() throws Exception {
        UserDAO userDAO=new UserDAO();
        User user=userDAO.getUserById(userId);
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if(user!=null){
            if(user.getUserPwd().equals(password)){
                session.put("LoginStatus","登陆成功");
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
}
