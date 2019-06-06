<%@ page import="com.t1708m.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");
%>
<html>
<head>
    <title>List Student</title>
</head>
<body>
    <h1>List Student</h1>
    <ul>
        <% for(int i = 0; i < list.size(); i++){%>
            <li><%= list.get(i).getFullName()%> - <%= list.get(i).getUsername()%></li>
        <%}%>
    </ul>
</body>
</html>
