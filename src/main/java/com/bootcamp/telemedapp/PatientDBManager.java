package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.Patient;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDBManager {

    private Connection conn;

    public PatientDBManager() {
        makeConnection();
    }


    public void makeConnection() {
        String createTable = "CREATE TABLE IF NOT EXISTS patient (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    name text ,\n"
                + "    surname text ,\n"
                + "    email text,\n"
                + "    date_of_birth datetime\n"
                + ");";

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:patient.s3db");
            Statement stmt = conn.createStatement();


            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addPatient(Patient a) {
        String sql = "INSERT INTO patient (name, surname, email, date_of_birth) VALUES(?, ?, ?, ?)";
        //RuntimeException exception = new RuntimeException();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getSurname());
            pstmt.setString(3, a.getEmail());
            if(a.getDateOfBirth() != null)
                pstmt.setDate(4, new java.sql.Date(a.getDateOfBirth().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public Patient getPatientByEmail(String email) {
        String sql = "SELECT * FROM patient where email = '"+ email + "'";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
               Patient p = new Patient();
               p.setName(resultSet.getString("name"));
               p.setSurname(resultSet.getString("surname"));
               p.setEmail(resultSet.getString("email"));
               p.setDateOfBirth(new java.util.Date(resultSet.getDate("date_of_birth").getTime()) );

                return p;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    public List<Patient> getPatientList() {
        List<Patient> patientList = new ArrayList<Patient>();

        String sql = "SELECT * FROM patient";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Patient p = new Patient();
                p.setName(resultSet.getString("name"));
                p.setSurname(resultSet.getString("surname"));
                p.setEmail(resultSet.getString("email"));
                p.setDateOfBirth(new java.util.Date(resultSet.getDate("date_of_birth").getTime()) );

                patientList.add(p);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return patientList;

    }

    public void delete(Patient db_p1) {

        String sql = "DELETE FROM patient where email = '"+ db_p1.getEmail() + "'";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            int r =  statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}