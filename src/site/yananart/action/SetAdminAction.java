package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.entity.User;

import java.sql.SQLException;
import java.util.Map;

public class SetAdminAction {
    private String id;
    private int type;

    public String find() throws SQLException {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        User user= GetDAO.getUserDAO().getUserById(id);
        if(user==null) {
            session.put("result","查询不到此用户");
            return "error";
        }
        session.remove("result");
        session.put("nowCho",user);
        return "success";
    }

    public String make(){
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        User user= (User) session.get("nowCho");
        String[] map={"系统工具","通讯社交","影音播放","新闻阅读","摄影图像","考试学习","网上购物","金融理财","生活休闲","旅游出行","办公商务"};
        if(type==-1){
            GetDAO.getUserDAO().removeAdmin(user.getUserId());
            session.put("result","已去除用户 "+user.getUserName()+"(ID:"+user.getUserId()+")子类管理员身份");
            session.remove("nowCho");
            return "success";
        }
        GetDAO.getUserDAO().setUserToAdmin(user.getUserId(),map[type]);
        session.put("result","已设置用户 "+user.getUserName()+"(ID:"+user.getUserId()+")为\""+map[type]+"\"子类管理员身份");
        session.remove("nowCho");
        return "success";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
