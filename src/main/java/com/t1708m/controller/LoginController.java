package com.t1708m.controller;

import com.t1708m.entity.Student;
import com.t1708m.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie :
                    cookies) {
                System.out.println(cookie.getUsename() + " - " + cookie.getValue() + " - " + cookie.getDomain());
            }
        }
        session = req.getSession();
        Student student = (Student) session.getAttribute("currentLoggedIn");
        req.setAttribute("member", student);
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.getWriter().println("Login success with account: " + username);
    }

    public static void main(String[] args) {
        String inputPassword = "2";
        StudentModel model = new StudentModel();
        Student student = model.findByUsenameAndStatus("yumeto231", Student.Status.ACTIVE);
        if (student == null){
            System.err.println("Tai khoan khong ton tai hoac bi xoa");
        }
        else {
            if (inputPassword.equals(student.getPassword())){
                System.out.println("login thanh cong");
            }else {
                System.err.println("sai thong tin tai khoan");
            }
        }
    }
}
