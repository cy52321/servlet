package com.a1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    public static int add(Question question){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            conn=JDBC.getConnection();
            String sql="insert into t_question(title,optionA,optionB,optionC,optionD,answer) values (?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result=ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,rs);
        }return result;
    }
    public static List<Question> find(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Question> ql=new ArrayList<>();
        int result=0;
        try {
            conn=JDBC.getConnection();
            String sql="select * from t_question";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                int s1=rs.getInt("questionID");
                String s2=rs.getString("title");
                String s3=rs.getString("optionA");
                String s4=rs.getString("optionB");
                String s5=rs.getString("optionC");
                String s6=rs.getString("optionD");
                String s7=rs.getString("answer");
                Question q=new Question(s1,s2,s3,s4,s5,s6,s7);
                ql.add(q);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,rs);
        }return ql;
    }

    public static Question findid(String questionid){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Question qu=null;
        try {
            conn=JDBC.getConnection();
            String sql="select * from t_question where questionID=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(questionid));
            rs=ps.executeQuery();
            while (rs.next()){
                Integer i1=rs.getInt("questionID");
                String s1=rs.getString("title");
                String s2=rs.getString("optionA");
                String s3=rs.getString("optionB");
                String s4=rs.getString("optionC");
                String s5=rs.getString("optionD");
                String s6=rs.getString("answer");
                qu=new Question(i1,s1,s2,s3,s4,s5,s6);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,rs);
        }return qu;
    }

    public static int update(Question question) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = JDBC.getConnection();
            String sql = "update t_question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            ps.setInt(7,question.getQuestionID());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close(conn, ps, rs);
        }
        return result;
    }

    public static int delete(String questionID){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            conn=JDBC.getConnection();
            String sql="delete from t_question where questionID=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.valueOf(questionID));
            result=ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,rs);
        }return result;
    }

    public static List<Question> test(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Question> ql=new ArrayList<>();
        int result=0;
        try {
            conn=JDBC.getConnection();
            String sql="select * from t_question order by rand() limit 0,4";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                int s1=rs.getInt("questionID");
                String s2=rs.getString("title");
                String s3=rs.getString("optionA");
                String s4=rs.getString("optionB");
                String s5=rs.getString("optionC");
                String s6=rs.getString("optionD");
                String s7=rs.getString("answer");
                Question q=new Question(s1,s2,s3,s4,s5,s6,s7);
                ql.add(q);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.close(conn,ps,rs);
        }return ql;
    }
}
