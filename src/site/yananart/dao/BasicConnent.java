package site.yananart.dao;

import java.sql.*;

public class BasicConnent {
    
    private final static String driverName="com.mysql.jdbc.Driver";
    private final static String databaseUrl="jdbc:mysql://localhost:3306/tool_manage_system";
    private final static String username="root";
    private final static String password="nounenrena";

    private boolean isConnent=false;

    private Connection conn;
    private Statement stmt;

    public BasicConnent(){
        getConnention();
    }

    private boolean getConnention(){
        try {
            Class.forName(driverName);
            System.out.println("加载驱动成功");
        }catch (Exception e){
            System.out.println("加载驱动失败");
            e.printStackTrace();
            return false;
        }

        try {
            conn=DriverManager.getConnection(databaseUrl,username,password);
            stmt=conn.createStatement();
            System.out.println("成功连接到数据库");
            isConnent=true;
            return true;
        }catch (Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getData(String sql) {
        System.out.println(sql);
        if(!isConnent){
            if(!getConnention()) return null;
        }
        try {
            System.out.println("查询成功");
            ResultSet resultSet=stmt.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询失败");
            return null;
        }
    }

    public boolean changeData(String sql){
        System.out.println(sql);
        if(!isConnent){
            if(!getConnention()) return false;
        }
        try {
            stmt.executeUpdate(sql);
            System.out.println("修改成功");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("修改失败");
            return false;
        }
    }

    public boolean haveData(String sql) {
        System.out.println(sql);
        if(!isConnent){
            if(!getConnention()) return false;
        }
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            int ans=0;
            while (resultSet.next()) ans++;
            if(ans>0){
                System.out.println("查询成功 含此数据");
                return true;
            }
            System.out.println("查询失败");
            return false;
        }catch (Exception e){
            System.out.println("查询失败");
            System.out.println(e.toString());
            return false;
        }
    }

    public void closeConnention(){
        if(isConnent){
            try {
                stmt.close();
                conn.close();
                isConnent=false;
                System.out.println("已断开");
                return;
            } catch (SQLException e) {
                System.out.println("断开失败");
                e.printStackTrace();
                return;
            }
        }else return;
    }
}
