package com.princekin.sims.repository;

import com.princekin.sims.entity.Student;
import com.princekin.sims.util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.valueOf;


public class StudentRepository {
    public List<Student> findAll() {//查找并显示所有基本信息
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Student> list=new ArrayList<>();
        try {
            connection= JDBCTools.getConnection();
            System.out.println(connection);
            String sql = "select * from student_info";
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            Student student=null;
            while(resultSet.next()){
                String name=resultSet.getString(1);
                String sex=resultSet.getString(2);
                String people=resultSet.getString(3);
                String political=resultSet.getString(4);
                int id=resultSet.getInt(5);
                String verify=resultSet.getString(6);
                String home=resultSet.getString(7);
                Date birthday=resultSet.getDate(8);
                String school=resultSet.getString(9);
                String speciality=resultSet.getString(10);
                String grade=resultSet.getString(11);
                String class_name=resultSet.getString(12);
                String password="000000";

                student=new Student(name,sex,people,political,id,verify,home,birthday,school,speciality,grade,class_name,password);

                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }
    //新增，按条件查询学生信息
    public List<Student> searchByInfo(String bySpecial,String byClass){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Student> list=new ArrayList<>();
        try {
            connection= JDBCTools.getConnection();
            System.out.println(connection);
            String sql = "select * from student_info";
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            Student student=null;
            while(resultSet.next()){
                String class_name=resultSet.getString(12);
                String speciality=resultSet.getString(10);
                if(class_name.equals(byClass)&&speciality.equals(bySpecial)){
                    String name=resultSet.getString(1);
                    String sex=resultSet.getString(2);
                    String people=resultSet.getString(3);
                    String political=resultSet.getString(4);
                    int id=resultSet.getInt(5);
                    String verify=resultSet.getString(6);
                    String home=resultSet.getString(7);
                    Date birthday=resultSet.getDate(8);
                    String school=resultSet.getString(9);
                    String grade=resultSet.getString(11);
                    String password="000000";

                    student=new Student(name,sex,people,political,id,verify,home,birthday,school,speciality,grade,class_name,password);

                    list.add(student);
                }
                else{

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    public List<Student> findByClass(String cla){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Student> list=new ArrayList<>();
        try {
            connection= JDBCTools.getConnection();
            System.out.println(connection);
            String sql = "select * from student_info";
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            Student student=null;
            while(resultSet.next()){
                String class_name=resultSet.getString(12);
                if(class_name.equals(cla)){
                    String name=resultSet.getString(1);
                    String sex=resultSet.getString(2);
                    String people=resultSet.getString(3);
                    String political=resultSet.getString(4);
                    int id=resultSet.getInt(5);
                    String verify=resultSet.getString(6);
                    String home=resultSet.getString(7);
                    Date birthday=resultSet.getDate(8);
                    String school=resultSet.getString(9);
                    String speciality=resultSet.getString(10);
                    String grade=resultSet.getString(11);
                    String password="000000";

                    student=new Student(name,sex,people,political,id,verify,home,birthday,school,speciality,grade,class_name,password);

                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;

    }
    //添加学生，但不包括成绩
    public void add(String name,String sex,String people,String political,int id,String verify,String home,Date birthday,String school,String speciality,String grade,String class_name,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection = JDBCTools.getConnection();
        System.out.println(connection);
        String sql = "insert into student_info(name,sex,people,political,id,verify,home,birthday,school,speciality,grade,class_name,password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sex);
            preparedStatement.setString(3, people);
            preparedStatement.setString(4,political);
            preparedStatement.setInt(5,id);
            preparedStatement.setString(6,verify);
            preparedStatement.setString(7,home);
            preparedStatement.setDate(8, (java.sql.Date) birthday);
            preparedStatement.setString(9,school);
            preparedStatement.setString(10,speciality);
            preparedStatement.setString(11,grade);
            preparedStatement.setString(12,class_name);
            preparedStatement.setString(13,password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    public void deleteByID(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection=JDBCTools.getConnection();
        String sql="delete from student_info where id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    public Student findByID(String id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from student_info where id=?";
        connection=JDBCTools.getConnection();
        Student student=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String name=resultSet.getString(1);
                String sex=resultSet.getString(2);
                String people=resultSet.getString(3);
                String political=resultSet.getString(4);
                int ID=resultSet.getInt(5);
                String verify=resultSet.getString(6);
                String home=resultSet.getString(7);
                Date birthday=resultSet.getDate(8);
                String school=resultSet.getString(9);
                String speciality=resultSet.getString(10);
                String grade=resultSet.getString(11);
                String class_name=resultSet.getString(12);
                String password=resultSet.getString(13);
                double calculus=resultSet.getDouble(14);
                double linear_algebra=resultSet.getDouble(15);
                double probability_theory=resultSet.getDouble(16);
                double algorithm=resultSet.getDouble(17);
                student=new Student(name,sex,people,political,ID,verify,home,birthday,school,speciality,grade,class_name,password,calculus,linear_algebra,probability_theory,algorithm);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return student;
    }

    public void update(String name,String sex,String people,String political,int id,String verify,String home,Date birthday,String school,String speciality,String grade,String class_name){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection = JDBCTools.getConnection();
        System.out.println(connection);
        try {
            String sql = "update student_info set name=?,sex=?,people=?,political=?,verify=?,home=?,birthday=?,school=?,speciality=?,grade=?,class_name=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sex);
            preparedStatement.setString(3, people);
            preparedStatement.setString(4,political);
            preparedStatement.setInt(12,id);
            preparedStatement.setString(5,verify);
            preparedStatement.setString(6,home);
            preparedStatement.setDate(7, (java.sql.Date) birthday);
            preparedStatement.setString(8,school);
            preparedStatement.setString(9,speciality);
            preparedStatement.setString(10,grade);
            preparedStatement.setString(11,class_name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }
    public void update_code(int id,String new_password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection = JDBCTools.getConnection();
        System.out.println(connection);
        String sql = "update student_info set password=? where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,new_password);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        StudentRepository studentRepository=new StudentRepository();
        System.out.println(studentRepository.findAll());
    }
}


