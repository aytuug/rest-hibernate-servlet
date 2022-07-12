package com.aakin.rest.hibernate.servlet.controller;


import com.aakin.rest.hibernate.servlet.dto.SchoolDto;
import com.aakin.rest.hibernate.servlet.dto.StudentDto;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Manager;
import com.aakin.rest.hibernate.servlet.hibernate.entity.School;
import com.aakin.rest.hibernate.servlet.hibernate.entity.Student;
import com.aakin.rest.hibernate.servlet.repository.ManagerRepository;
import com.aakin.rest.hibernate.servlet.repository.SchoolRepository;
import com.aakin.rest.hibernate.servlet.repository.StudentRepository;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/school")
public class SchoolController extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SchoolRepository schoolRepository = new SchoolRepository();
        ManagerRepository managerRepository = new ManagerRepository();
        StudentRepository studentRepository = new StudentRepository();

        List<School> schools = schoolRepository.GetSchoolList();
        List<SchoolDto> schoolDtos = new ArrayList<>();

        for (School school : schools){
            Manager manager =  managerRepository.FindById(school.getId());
            List<Student> students = studentRepository.GetStudentListBySchoolId(school.getId());
            List<StudentDto> studentDtos = new ArrayList<>();

            for (Student student : students){
                StudentDto studentDto = new StudentDto();
                studentDto.setSchoolName(student.getSchool().getSchoolName());
                studentDto.setFirstName(student.getFirstName());
                studentDto.setLastName(student.getLastName());
                studentDto.setId(student.getId());
                studentDtos.add(studentDto);
            }

            SchoolDto schoolDto = new SchoolDto();
            schoolDto.setId(school.getId());
            schoolDto.setSchoolName(school.getSchoolName());
            schoolDto.setManagerName(manager.getFirstName()+ " " + manager.getLastName());
            schoolDto.setStudents(studentDtos);
            schoolDtos.add(schoolDto);

        }

        String schoolJsonString = this.gson.toJson(schoolDtos);
        PrintWriter out = resp.getWriter();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8"); //gerekli değil ancak eklemekte fayda var.
        out.print(schoolJsonString);

        out.flush();
    }
}
