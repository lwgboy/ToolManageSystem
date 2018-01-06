package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.dao.ToolDAO;
import site.yananart.dao.UserDAO;
import site.yananart.entity.Tool;
import site.yananart.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class SearchAction {
    private String searchType;
    private String content;

    public String execute() throws SQLException {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if (content.equals("")){
            session.put("searchStatus","请输入搜索内容");
            return "error";
        }
        ToolDAO toolDAO=new ToolDAO();
        ArrayList<Tool> tools;
        if(searchType.equals("name")){
            tools=toolDAO.getToolByName(content);
            if(tools==null){
                session.put("searchStatus","未找到任何工具");
                return "error";
            }
            session.put("reslut",tools);
            session.put("searchStatus","搜索成功");
            return "success";
        }else if(searchType.equals("tag")){
            tools=toolDAO.getToolByTag(content);
            if(tools==null){
                session.put("searchStatus","未找到任何工具");
                return "error";
            }
            session.put("reslut",tools);
            session.put("searchStatus","搜索成功");
            return "success";
        }else if(searchType.equals("describe")){
            tools=toolDAO.getToolByDescribe(content);
            if(tools==null){
                session.put("searchStatus","未找到任何工具");
                return "error";
            }
            session.put("reslut",tools);
            session.put("searchStatus","搜索成功");
            return "success";
        }else if(searchType.equals("uploadUser")) {
            ArrayList<User> users;
            tools=new ArrayList<>();
            UserDAO userDAO=new UserDAO();
            users=userDAO.getUserByName(content);
            ArrayList<Tool> mid;
            if(users!=null){
                for (int i = 0; i < users.size() ; i++) {
                    mid=toolDAO.getToolByUploadUserId(users.get(i).getUserId());
                    if(mid==null) continue;
                    mid.forEach(tools::add);
                }
            }
            mid = toolDAO.getToolByUploadUserId(content);
            if(mid!=null) mid.forEach(tools::add);
            if(tools.size()==0){
                session.put("searchStatus","未找到任何工具");
                return "error";
            }
            session.put("reslut", tools);
            session.put("searchStatus", "搜索成功");
            return "success";
        }
        session.put("searchStatus","搜索失败");
        return "error";
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
