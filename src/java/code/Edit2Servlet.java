/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package code;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Edit2Servlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        PrintWriter out= resp.getWriter();
        String sid=req.getParameter("id");
        int id=Integer.parseInt(sid);
        
        String name=req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        student s=new student();
        
        
        s.setName(name);
        s.setAge(age);
        s.setId(id);
        int status=studentDAO.Edit(s);
        if (status>1) {
            req.getRequestDispatcher("viewServlet").include(req, resp);}
         
     }
    
}
