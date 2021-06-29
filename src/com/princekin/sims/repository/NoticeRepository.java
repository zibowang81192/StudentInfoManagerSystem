package com.princekin.sims.repository;

import com.princekin.sims.entity.Notice;
import com.princekin.sims.util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeRepository {
    public List<Notice> findAllNotice(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Notice> list_notice=new ArrayList<Notice>();
        connection= JDBCTools.getConnection();
        System.out.println(connection);
        String sql = "select * from notice";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            Notice notice=null;
            while(resultSet.next()){
                String topic=resultSet.getString(1);
                String text=resultSet.getString(2);
                Date date=resultSet.getDate(3);
                int index=resultSet.getInt(4);
                notice=new Notice(topic,text,date,index);
                list_notice.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list_notice;
    }

    public Notice findByIndex(int index){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Notice> list=new ArrayList<>();
        connection= JDBCTools.getConnection();
        System.out.println(connection);
        String sql = "select * from notice where id=?";
        Notice notice=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);
            resultSet=preparedStatement.executeQuery();
            String topic=resultSet.getString(1);
            String text=resultSet.getString(2);
            Date date=resultSet.getDate(3);
            //int Index=resultSet.getInt(4);
            notice=new Notice(topic,text,date,index);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return notice;
    }
    public void add(String topic,String text,Date date){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection = JDBCTools.getConnection();
        System.out.println(connection);
        String sql = "insert into notice(topic,text,date) values(?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,topic);
            preparedStatement.setString(2,text);
            preparedStatement.setDate(3, (java.sql.Date) date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }
}
