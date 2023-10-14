package com.example.demo.jdbc;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/*
  <dependencies>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.13</version>
    </dependency>
    <dependency>
      <groupId>javax</groupId>
      <artifactId>javaee-api</artifactId>
      <version>8.0.1</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>

 */
@WebServlet("/crud")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("save") != null) {
                int studentRollNumber = Integer.parseInt(req.getParameter("studentRollNumber"));
                String studentName = req.getParameter("studentName");
                Crud.insert(studentRollNumber, studentName);
            } else if (req.getParameter("search") != null) {

                int studentRollNumber = Integer.parseInt(req.getParameter("studentRollNumber"));
                Student student= Crud.search(studentRollNumber);
                req.setAttribute("student", student);

            } else if (req.getParameter("edit") != null) {
                int studentRollNumber = Integer.parseInt(req.getParameter("studentRollNumber"));
                String studentName = req.getParameter("studentName");
                Crud.update(studentRollNumber, studentName);
            } else if (req.getParameter("delete") != null) {
                int studentRollNumber = Integer.parseInt(req.getParameter("studentRollNumber"));
                Crud.delete(studentRollNumber);
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
