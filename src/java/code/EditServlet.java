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


public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        String sid=req.getParameter("id");
        int id=Integer.parseInt(sid);
        student s=studentDAO.GetStudentBy(id);
        out.println("<form action='Edit2Servlet'>");
        out.println("<table>");
                  out.println("<tr><td><input type='hidden' name='id' value="+s.getId()+"></td></tr>");      
                 out.println("<tr><td><input type='text' name='name' value="+s.getName()+"></td></tr>");      
                 out.println("<tr><td><input type='number' name='age' value="+s.getAge()+"></td></tr>");
                                  out.println("<tr><td><input type='submit' value='submit'></td></tr>");

          out.println("</table>"); 
          out.println("</form>");
    }

    
}
