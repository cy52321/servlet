package com.a1;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserDao {

    public static int add(User user, HttpServletRequest request){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Map map=null;
        int result=0;
        try {
            ServletContext application=request.getServletContext();
            map=(Map)application.getAttribute("key");
            Iterator it=map.keySet().iterator();
            while (it.hasNext()){
                conn=(Connection)it.next();
                boolean flag= (boolean) map.get(conn);
                if(flag==true){
                    map.put(conn,false);
                    break;
                }
            }
            String sql="insert into t_user1(userName,password,sex,email) values(?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            map.put(conn,true);
        }return result;
    }
    public static List findall() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userlist = new ArrayList<>();
        try {
            conn = JDBC.getConnection();
            String sql = "select * from t_user1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userid = rs.getInt("userId");
                String username = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                User user = new User(userid, username, password, sex, email);
                userlist.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close(conn, ps, rs);
        }
        return userlist;
    }
    public static int delete(String userId){
        Connection conn=null;
        PreparedStatement ps=null;
        int result=0;
        try {
            conn=JDBC.getConnection();
            String sql="delete from t_user1 where userId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(userId));
            result=ps.executeUpdate();
            }
         catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,null);
        }return result;
    }
    public static int login(String username,String password){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            conn=JDBC.getConnection();
            String sql="select count(*) from t_user1 where userName=? and password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while(rs.next()){
                result=rs.getInt("count(*)");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,rs);
        }return result;
    }
}
