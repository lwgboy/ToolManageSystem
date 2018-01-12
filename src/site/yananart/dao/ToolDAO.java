package site.yananart.dao;

import site.yananart.entity.Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class ToolDAO {
    private BasicConnent connention;

    public ToolDAO(){
        connention=new BasicConnent();
    }

    private ArrayList<Tool> turnToTool(ResultSet resultSet) throws SQLException {
        ArrayList<Tool> tools=new ArrayList<Tool>();
        while (resultSet.next()){
            tools.add(new Tool(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getTimestamp(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getInt(10),
                    resultSet.getInt(11),
                    resultSet.getInt(12)));
        }
        if(tools.size()==0) return null;
        return tools;
    }

    private ResultSet getToolSet(String findType, String findContent, String way){
        String sql="select * from tool_table where " + findType+ ' ' + way + " \"" + findContent + "\"";
        return connention.getData(sql);
    }

    public Tool getToolById(String id) throws SQLException {
        ResultSet resultSet=getToolSet("tool_id",id,"=");
        ArrayList<Tool> tools = turnToTool(resultSet);
        if(tools==null) return null;
        return tools.get(0);
    }

    public ArrayList<Tool> getToolByName(String name) throws SQLException {
        name='%'+name+'%';
        ResultSet resultSet=getToolSet("tool_name",name,"like");
        return turnToTool(resultSet);
    }

    public ArrayList<Tool> getToolByType(int type) throws SQLException {
        String sql="select * from tool_table where tool_type=" + String.valueOf(type);
        ResultSet resultSet=connention.getData(sql);
        return turnToTool(resultSet);
    }

    public ArrayList<Tool> getToolByDescribe(String describe) throws SQLException {
        describe='%'+describe+'%';
        ResultSet resultSet=getToolSet("tool_describe",describe,"like");
        return turnToTool(resultSet);
    }

    public ArrayList<Tool> getToolByTag(String tag) throws SQLException {
        tag='%'+tag+'%';
        ResultSet resultSet=getToolSet("tool_tag",tag,"like");
        return turnToTool(resultSet);
    }

    public ArrayList<Tool> getToolByUploadUserId(String id) throws SQLException {
        ResultSet resultSet=getToolSet("upload_user_id",id,"=");
        return turnToTool(resultSet);
    }

    public void changeStars(String id,boolean up){
        String sql;
        if(up) sql="update tool_table set star_number=star_number+1 where tool_id=\""+id+"\"";
        else sql="update tool_table set star_number=star_number-1 where tool_id=\""+id+"\"";
        connention.changeData(sql);
    }

    public void changeComments(String id){
        String sql="update tool_table set comment_number=comment_number+1 where tool_id=\""+id+"\"";
        connention.changeData(sql);
    }

    public void insertNewTool(String name,String version,int type,String user_id,String des,String tag,String url) throws SQLException {
        Random random = new Random();
        boolean flag=true;
        String s="";
        while(flag){
            long l=random.nextLong();
            if(l<0) continue;
            s = String.valueOf(l);
            if(getToolById(s)==null){
                flag=false;
            }
        }
        String sql="insert into tool_table values (\""+s+"\",\""+name+"\",\""+version+"\","+type+",default,\""+user_id+"\",\""+des+"\",\""+tag+"\",\""+url+"\",default,default,default)";
        connention.changeData(sql);
    }

    public void addDownload(String id){
        String sql="update tool_table set download_number=download_number+1 where tool_id=\""+id+"\"";
        connention.changeData(sql);
    }

    public void closeConnect(){
        connention.closeConnention();
    }
}
