package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.UserDAO;
import site.yananart.entity.User;

import java.util.Map;

public class ChangUserInformationAction {
    private String OldPwd;
    private String NewPwd;
    private String NewPwdAgain;

    public String execute(){
        UserDAO userDAO= GetDAO.getUserDAO();
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        User user= (User) session.get("user");
        if(user.getUserPwd().equals(OldPwd)){
            if(NewPwd.equals(NewPwdAgain)){
                if(NewPwd.equals("")){
                    session.put("ChInfStatus","新密码为空");
                    return "error";
                }
                if(userDAO.changeUserPwdById(user.getUserId(),NewPwd)){
                    session.remove("ChInfStatus");
                    return "success";
                }
                session.put("ChInfStatus","修改失败");
                return "error";
            }else{
                session.put("ChInfStatus","两次密码不一致");
                return "error";
            }
        }else{
            session.put("ChInfStatus","原密码错误");
            return "error";
        }
    }

    public String out() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.remove("ChInfStatus");
        return "success";
    }

    public String getOldPwd() {
        return OldPwd;
    }

    public void setOldPwd(String oldPwd) {
        OldPwd = oldPwd;
    }

    public String getNewPwd() {
        return NewPwd;
    }

    public void setNewPwd(String newPwd) {
        NewPwd = newPwd;
    }

    public String getNewPwdAgain() {
        return NewPwdAgain;
    }

    public void setNewPwdAgain(String newPwdAgain) {
        NewPwdAgain = newPwdAgain;
    }
}
