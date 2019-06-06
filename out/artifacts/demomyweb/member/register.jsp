<%@ page import="com.t1708m.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-05-28
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    if(student == null){
        student = new Student();
    }
%>
<html>
<head>
    <title>Register page</title>
</head>
<body>
    <h1>Register page</h1>
    <form action="/member/register" method="post">
        <div>
            Username <input type="text" name="username" value="<%=student.getUsername()%>">
        </div>
        <div>
            Password <input type="password" name="password">
        </div>
        <div>
            Confirm Password <input type="password" name="confirmPassword">
        </div>
        <div>
            Fullname <input type="text" name="fullName" value="<%=student.getFullName()%>">
        </div>
        <div>
            Email <input type="email" name="email" value="<%=student.getEmail()%>">
        </div>
        <div>
            Address <input type="text" name="address" value="<%=student.getAddress()%>">
        </div>
        <div>
            Phone <input type="text" name="phone" value="<%=student.getPhone()%>">
        </div>

        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>
