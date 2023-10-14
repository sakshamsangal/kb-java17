package com.saksham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Crud {

    public static Statement statement;
    public static Connection connection;

    public static List<Patient> view() throws Exception {
        String sql = "SELECT * FROM patient";
        ResultSet resultSet = statement.executeQuery(sql);

        List<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {
            Patient patient = new Patient();

            patient.setId(resultSet.getInt(1));
            patient.setPatient_name(resultSet.getString(2));
            patient.setPr(resultSet.getInt(3));
            patient.setBp_systolic(resultSet.getInt(4));
            patient.setBp_diastolic(resultSet.getInt(5));
            patient.setTemp(resultSet.getFloat(6));
            patient.setRr(resultSet.getInt(7));
            patient.setSpo2(resultSet.getInt(8));
            patient.setO2(resultSet.getFloat(9));
            patient.setFio2(resultSet.getFloat(10));
            patient.setOther(resultSet.getString(11));
            patient.setRemarks(resultSet.getString(12));
            patient.setGcs(resultSet.getFloat(13));
            patient.setUrine(resultSet.getFloat(14));
            patient.setInotrope(resultSet.getString(15));
            patient.setPosition(resultSet.getString(16));
            patient.setIntake(resultSet.getString(17));
            patient.setSteroids(resultSet.getString(18));
            patient.setAntibiotics(resultSet.getString(19));
            patient.setClexane(resultSet.getString(20));
            patients.add(patient);
        }
        return patients;
    }

    static {
        try {
            connection = Database.getConnection();
            Crud.statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void insert(int id, String patient_name, int pr, int bp_systolic, int bp_diastolic, float temp, int rr, int spo2, float o2, float fio2, String other, String remarks, float gcs, float urine, String inotrope, String position, String intake, String steroids, String antibiotics, String clexane) throws SQLException {

        String sql = "INSERT INTO patient VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, patient_name);
        preparedStatement.setInt(3, pr);
        preparedStatement.setInt(4, bp_systolic);
        preparedStatement.setInt(5, bp_diastolic);
        preparedStatement.setFloat(6, temp);
        preparedStatement.setInt(7, rr);
        preparedStatement.setInt(8, spo2);
        preparedStatement.setFloat(9, o2);
        preparedStatement.setFloat(10, fio2);
        preparedStatement.setString(11, other);
        preparedStatement.setString(12, remarks);
        preparedStatement.setFloat(13, gcs);
        preparedStatement.setFloat(14, urine);
        preparedStatement.setString(15, inotrope);
        preparedStatement.setString(16, position);
        preparedStatement.setString(17, intake);
        preparedStatement.setString(18, steroids);
        preparedStatement.setString(19, antibiotics);
        preparedStatement.setString(20, clexane);

        preparedStatement.executeUpdate();
    }
}
