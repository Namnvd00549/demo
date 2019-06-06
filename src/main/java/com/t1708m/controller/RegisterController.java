package com.t1708m.controller;

import com.google.gson.Gson;
import com.t1708m.entity.Student;
import com.t1708m.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    private static StudentModel model = new StudentModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        req.setAttribute("student", student);
        req.getRequestDispatcher("/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setFullName(fullName);
        student.setEmail(email);
        student.setAddress(address);
        student.setPhone(phone);

        model.saveV2(student);
        resp.getWriter().print(new Gson().toJson(student));
    }

}
