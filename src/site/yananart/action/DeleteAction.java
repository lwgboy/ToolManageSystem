package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import site.yananart.controller.GetDAO;
import site.yananart.dao.ToolDAO;
import site.yananart.entity.Tool;
import site.yananart.entity.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class DeleteAction {

    private String id;

    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        String path = ServletActionContext.getServletContext().getRealPath("tool");
        ToolDAO toolDAO= GetDAO.getToolDAO();
        Tool tool = toolDAO.getToolById(id);
        String url=tool.getToolUrl();
        System.out.println(path + "\\" + url);
        File file=new File(path + "\\" + url);
        //System.out.println(file.getAbsolutePath());
        if(file.exists()&&file.isFile()) file.delete();
        toolDAO.delete(id);
        User user= (User) session.get("user");
        ArrayList<Tool> tools=toolDAO.getToolListByType(user.getManageType());
        session.put("tools",tools);
        return "success";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
