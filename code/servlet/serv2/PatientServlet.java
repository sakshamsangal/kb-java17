package com.saksham;

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

                int id = Integer.parseInt(req.getParameter("id"));
                String patient_name = req.getParameter("patient_name");
                int pr = Integer.parseInt(req.getParameter("pr"));
                int bp_systolic = Integer.parseInt(req.getParameter("bp_systolic"));
                int bp_diastolic = Integer.parseInt(req.getParameter("bp_diastolic"));
                float temp = Float.parseFloat(req.getParameter("temp"));
                int rr = Integer.parseInt(req.getParameter("rr"));
                int spo2 = Integer.parseInt(req.getParameter("spo2"));
                float o2 = Float.parseFloat(req.getParameter("o2"));
                float fio2 = Float.parseFloat(req.getParameter("fio2"));
                String other = req.getParameter("other");
                String remarks = req.getParameter("remarks");
                float gcs = Float.parseFloat(req.getParameter("gcs"));
                float urine = Float.parseFloat(req.getParameter("urine"));
                String inotrope = req.getParameter("inotrope");
                String position = req.getParameter("position");
                String Intake = req.getParameter("Intake");
                String Steroids = req.getParameter("Steroids");
                String Antibiotics = req.getParameter("Antibiotics");
                String Clexane = req.getParameter("Clexane");
                Crud.insert(id ,patient_name ,pr ,bp_systolic ,bp_diastolic ,temp ,rr ,spo2 ,o2 ,fio2 ,other ,remarks ,gcs ,urine ,inotrope ,position ,Intake ,Steroids ,Antibiotics ,Clexane);
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
