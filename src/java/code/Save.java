/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package code;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
       String name=req.getParameter("Name");
       out.println();
       int age=Integer.parseInt( req.getParameter("Age"));
       student s=new student();
       s.setAge(age);
       s.setName(name);
       int st=studentDAO.save(s);
        if (st==1) {
            out.print("<h1>Record inserted</h1>");
            req.getRequestDispatcher("index.html").include(req, resp);
        }
        else{
        out.println("Sorry");
        }
       
    }
    

   
   

}
