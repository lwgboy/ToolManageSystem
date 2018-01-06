package site.yananart.action;

import com.opensymphony.xwork2.ActionContext;
import site.yananart.dao.CommentDAO;
import site.yananart.dao.ToolDAO;
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
        ToolDAO toolDAO=new ToolDAO();
        CommentDAO commentDAO=new CommentDAO();
        User user= (User) session.get("user");
        Comment comment;
        Tool tool = null;
        ArrayList<Tool> tools=(ArrayList<Tool>)session.get("reslut");
        for (int i = 0; i < tools.size(); i++) {
            tool=tools.get(i);
            if(tool.getToolId().equals(toolId)) break;
        }
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
                if(x.getUserId().equals(user.getUserId())) return;
                if(x.isComment()) commentArrayList.add(x);
            });
        }
        session.put("comments",commentArrayList);
        return "success";
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }
}
