<%-- 
    Document   : view
    Created on : 25-Oct-2023, 9:50:40 PM
    Author     : Admin
--%>
<%@page import="java.sql.*" %>%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        
        <a href="index.html"></a>
        <%
        List<student> list=studentDAO.AllStudent();
        
        %>
        <table>
            <% 
            for(student s.list){
%>
            <tr>
                <th><%=s.getName()%></th>
                <th><%=s.getAge()%></th>
            </tr>
            <tr>
                <td><a></a></td>
                <td><a></a></td>
                <%}%></center>
        
    </body>
</html>
