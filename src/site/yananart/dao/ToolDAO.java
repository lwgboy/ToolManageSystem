package site.yananart.dao;

import site.yananart.entity.Tool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        ResultSet resultSet=getToolSet("tool_type",String.valueOf(type),"=");
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
        ResultSet resultSet=getToolSet("tool_tag",id,"=");
        return turnToTool(resultSet);
    }
}
