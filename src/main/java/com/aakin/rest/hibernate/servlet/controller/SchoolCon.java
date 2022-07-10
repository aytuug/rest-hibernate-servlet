package com.aakin.rest.hibernate.servlet.controller;

import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.repository.SchoolRepository;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/school")
public class SchoolCon extends HttpServlet {
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SchoolRepository schoolRepository = new SchoolRepository();
        List<School> schools = schoolRepository.GetSchoolList();

        String schoolJsonString = this.gson.toJson(schools);
        PrintWriter out = resp.getWriter();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(schoolJsonString);

        out.flush();

    }
}
