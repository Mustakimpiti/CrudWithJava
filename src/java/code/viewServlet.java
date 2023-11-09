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
import java.util.List;


public class viewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<a href='index.html'>Add Student</a>");
        List<student> list=studentDAO.AllStudent();
        out.println("<table border:1>");
        out.println("<tr><th>Id</th><th>Name</th><th>Age</th></tr>");
        for (student object : list) {
            out.println("<tr><td>"+object.getId()+"</td><td>"+object.getName()+"</td><td>"+object.getAge()+"</td>");
            out.println("<td><a href='EditServlet?id="+object.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+object.getId()+"'>Delete</a></td></tr>");
            
        }
        out.println("</table>");
        
        
    }

    
    
}
