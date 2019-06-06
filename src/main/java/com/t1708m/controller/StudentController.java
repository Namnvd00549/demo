package com.t1708m.controller;

import com.google.gson.Gson;
import com.t1708m.entity.Student;
import com.t1708m.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class StudentController extends HttpServlet {

    private static StudentModel model = new StudentModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> list = model.getList();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/member/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Hello By Post " + req.getParameter("email"));
    }
}
