package com.aakin.rest.hibernate.servlet.controller;

import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.repository.ManagerRepository;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Manager", urlPatterns = "/manager")
public class ManagerController extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerRepository managerRepository = new ManagerRepository();

        List<Manager> managers = managerRepository.GetManagerList();

        String managerJsonString = this.gson.toJson(managers);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(managerJsonString);

        out.flush();
    }
}
