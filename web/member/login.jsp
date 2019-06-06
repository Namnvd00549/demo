<%@ page import="com.t1708m.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    if(student == null){
        student = new Student();
    }%>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <h1>Login page</h1>
    <%= student.getUsername()%>
    <form action="/member/login" method="post">
        <div>
            Username <input type="text" name="username">
        </div>
        <div>
            Password <input type="password" name="password">
        </div>
        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>
