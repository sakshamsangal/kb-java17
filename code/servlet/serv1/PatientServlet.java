package com.saksham.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/crud")
public class PatientServlet extends HttpServlet {
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
