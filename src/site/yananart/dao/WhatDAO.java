package site.yananart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import site.yananart.entity.What;

public class WhatDAO {
    private BasicConnent connention;

    public WhatDAO(){
        connention=new BasicConnent();
    }

    public void insertContent(String userId, String toolId, Timestamp time,String content){
        String sql="insert into what_table values(\""+toolId+"\",\""+userId+"\",\""+time+"\",\""+content+"\")";
        connention.changeData(sql);
    }

    public ArrayList<What> getComment(String toolId,String userId) throws SQLException {
        ArrayList<What> whats=new ArrayList<>();
        String sql="select * from what_table where tool_id=\""+toolId+"\" and user_id=\""+userId+"\"";
        ResultSet resultSet=connention.getData(sql);
        while (resultSet.next()){
            String comment=resultSet.getString(4);
            Timestamp timestamp=resultSet.getTimestamp(3);
            whats.add(new What(comment,timestamp));
        }
        if(whats.size()==0) return null;
        return whats;
    }
}
