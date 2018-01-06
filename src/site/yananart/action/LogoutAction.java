package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class LogoutAction {
    public String logout(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.clear();
        return "success";
    }
}
