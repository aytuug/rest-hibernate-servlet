package com.aakin.rest.hibernate.servlet.controller;

import com.aakin.rest.hibernate.servlet.hibernate.entity.Teacher;
import com.aakin.rest.hibernate.servlet.repository.TeacherRepository;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/teacher")
public class TeacherController extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeacherRepository teacherRepository = new TeacherRepository();

        List<Teacher> teachers = teacherRepository.GetTeacherList();

        String teacherJsonString = this.gson.toJson(teachers);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(teacherJsonString);

        out.flush();
    }
}
