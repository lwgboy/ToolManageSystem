package site.yananart.dao;

import site.yananart.entity.Comment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentDAO {
    private BasicConnent connention;

    public CommentDAO(){
        connention=new BasicConnent();
    }

    private ArrayList<Comment> turnToComment(ResultSet resultSet) throws Exception{
        ArrayList<Comment> comments=new ArrayList<>();
        while (resultSet.next()){
            comments.add(new Comment(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getBoolean(3),
                    resultSet.getBoolean(4),
                    resultSet.getString(5),
                    resultSet.getTimestamp(6)));
        }
        if(comments.size()==0) return null;
        return comments;
    }

    private ArrayList<Comment> getCommentSet(String findType,String findContent) throws Exception {
        String sql="select * from comment_table where " + findType+ "=" + "\"" + findContent + "\"";
        return turnToComment(connention.getData(sql));
    }

    public Comment getCommentById(String toolId,String userId) throws Exception {
        String sql = "select * from comment_table where tool_id=\"" + toolId + "\" and user_id=\"" + userId + "\"";
        ArrayList<Comment> comments=turnToComment(connention.getData(sql));
        if(comments==null) return null;
        return comments.get(0);
    }

    public ArrayList<Comment> getCommentByToolId(String id) throws Exception {
        return getCommentSet("tool_id",id);
    }

    public ArrayList<Comment> getCommentByUserId(String id) throws Exception {
        return getCommentSet("user_id",id);
    }

    public boolean isHaveComment(String toolId,String userId) {
        String sql="select * from comment_table where tool_id=\""+toolId+"\" and user_id=\""+userId+"\"";
        return connention.haveData(sql);
    }

    public void createComment(String toolId,String userId){
        String sql="insert into comment_table values(\""+toolId+"\",\""+userId+"\",default,default,default,null)";
        connention.changeData(sql);
    }

    public boolean insertComment(String toolId,String userId,String comment) {
        if(!isHaveComment(toolId,userId)){
            String sql="insert into comment_table values(\""+toolId+"\",\""+userId+"\",default,true,\""+comment+"\",null)";
            return connention.changeData(sql);
        }else{
            String sql="update comment_table set comment_content=\""+comment+"\",commend_time=default,is_comment=true where tool_id=\""+toolId+"\" and user_id=\""+userId+"\"";
            return connention.changeData(sql);
        }
    }

    public boolean makeStar(String toolId,String userId) {
        if(!isHaveComment(toolId,userId)){
            String sql="insert into comment_table values(\""+toolId+"\",\""+userId+"\",true,default,default,null)";
            return connention.changeData(sql);
        }else{
            String sql="update comment_table set is_star=true where tool_id=\""+toolId+"\" and user_id=\""+userId+"\"";
            return connention.changeData(sql);
        }
    }
}
