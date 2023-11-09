/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class studentDAO {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mustakim","root","");
        } catch (Exception e) {
        }
        return con;
        
    }
    public static int save(student s){
    int status=0;
        try {
            Connection con=studentDAO.getConnection();
            PreparedStatement pstmt=con.prepareStatement("insert into student (SName,SAge) values (?,?)");
            pstmt.setString(1,s.getName());
            pstmt.setInt(2, s.getAge());
            status=pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }
    
    public static List<student> AllStudent(){
        List<student> list=new ArrayList<student>();
        try {
            Connection con=studentDAO.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select * from student");
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                
                student s=new student();
                s.setId(rs.getInt("SNo"));
                s.setName(rs.getString("SName"));
                s.setAge(rs.getInt("SAge"));
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
        
    
    }
    
    public static int Edit(student s){
    int status=0;
        try {
            Connection con=studentDAO.getConnection();
            PreparedStatement pstmt=con.prepareStatement("Update student set SName=?,SAge=? where SNo=?");
            pstmt.setString(1,s.getName());
            pstmt.setInt(2, s.getAge());
            pstmt.setInt(3, s.getId());
            status=pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }
    
    
    public static int Delete(int id){
    int status=0;
        try {
            Connection con=studentDAO.getConnection();
            PreparedStatement pstmt=con.prepareStatement("delete from student where SNo=?");
            pstmt.setInt(1, id);
            status=pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        return status;
    }
    
    
    public static student GetStudentBy(int id){
    int status=0;
    student s=new student();
    try {
            Connection con=studentDAO.getConnection();
            PreparedStatement pstmt=con.prepareStatement("select * from student  where SNo=?");
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            
            while (rs.next()) {  
                
                s.setId(rs.getInt("SNo"));
                s.setName(rs.getString("SName"));
                s.setAge(rs.getInt("SAge"));
            
        }
            con.close();
        } catch (Exception e) {
        }
        return s;
    }
    
}
