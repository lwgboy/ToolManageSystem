package site.yananart.dao;

import site.yananart.entity.User;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private BasicConnent connention;

    public UserDAO(){
        connention=new BasicConnent();
    }

    private ArrayList<User> turnToUser(ResultSet resultSet) throws SQLException {
        ArrayList<User> users=new ArrayList<>();
        while (resultSet.next()){
            users.add(new User(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)));
        }
        if(users.size()==0) return null;
        return users;
    }

    public User getUserById(String id) throws SQLException {
        String sql="select * from user_table where user_id = \"" + id + "\"";
        ResultSet result = connention.getData(sql);
        ArrayList<User> users=turnToUser(result);
        if(users==null) return null;
        return users.get(0);
    }

    public ArrayList<User> getUserByName(String name) throws SQLException {
        String sql="select * from user_table where user_name = \"" + name + "\"";
        ResultSet result = connention.getData(sql);
        return turnToUser(result);
    }

    public boolean changeUserPwdById(String id, String newPwd){
        String sql="update user_table set user_pwd=\"" +newPwd+ "\" where user_id=\"" + id + "\"";
        return connention.changeData(sql);
    }

    public void setUserToAdmin(String id,String url){
        String sql="update user_table set user_type=1,manage_url=\"/" + url + "\" where user_id=\"" + id + "\"";
        connention.changeData(sql);
    }

    public void removeAdmin(String id){
        String sql="update user_table set user_type=0,manage_url=default where user_id=\"" + id + "\"";
        connention.changeData(sql);
    }

    public void closeConnect(){
        connention.closeConnention();
    }
}
