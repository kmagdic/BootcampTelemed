package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.BloodPressureRecord;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class RecordDBManager {

    private Connection conn;

    public RecordDBManager(){ makeConnection(); }


    public void makeConnection() {
        String createTable = "CREATE TABLE IF NOT EXISTS record (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    timestamp datetime,\n"
                + "    email text,\n"
                + "    bloodPressure1 text,\n"
                + "    bloodPressure2 text, \n"
                + "    description text \n"
                + "    ) ;";

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:record.s3db");
            Statement stmt = conn.createStatement();


            stmt.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addRecord(BloodPressureRecord b) {
        String sql = "INSERT INTO record (timestamp, email, bloodPressure1, bloodPressure2, description) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new Date(b.getTimestamp().getTime()));
            pstmt.setString(2, b.getEmail());
            pstmt.setString(3, b.getBloodPressure1());
            pstmt.setString(4, b.getBloodPressure2());
            pstmt.setString(5, b.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<BloodPressureRecord> getRecordList() {
        List<BloodPressureRecord> recordList = new ArrayList<BloodPressureRecord>();

        String sql = "SELECT * FROM record";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                BloodPressureRecord r = new BloodPressureRecord();
                r.setTimestamp(new java.util.Date(resultSet.getDate("timestamp").getTime()) );
                r.setEmail(resultSet.getString("email"));
                r.setBloodPressure1(resultSet.getString("bloodPressure1"));
                r.setBloodPressure2(resultSet.getString("bloodPressure2"));
                r.setDescription(resultSet.getString("description"));


                recordList.add(r);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return recordList;

    }

    public List<BloodPressureRecord> getPatientRecords(String currEmail) {
        List<BloodPressureRecord> recordList = new ArrayList<BloodPressureRecord>();

        String sql =  "SELECT * FROM record WHERE email = '"+ currEmail + "' order by timestamp desc";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                BloodPressureRecord r = new BloodPressureRecord();
                r.setTimestamp(new java.util.Date(resultSet.getDate("timestamp").getTime()) );
                r.setEmail(resultSet.getString("email"));
                r.setBloodPressure1(resultSet.getString("bloodPressure1"));
                r.setBloodPressure2(resultSet.getString("bloodPressure2"));
                r.setDescription(resultSet.getString("description"));


                recordList.add(r);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return recordList;

    }

 /*   public BloodPressureRecord getPatientRecords(String currEmail) {
        String sql = "SELECT * FROM record WHERE email = '"+ currEmail + "'";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                BloodPressureRecord r = new BloodPressureRecord();
                r.setTimestamp(new java.util.Date(resultSet.getDate("timestamp").getTime()) );
                r.setEmail(resultSet.getString("email"));
                r.setBloodPressure1(resultSet.getString("bloodPressure1"));
                r.setBloodPressure2(resultSet.getString("bloodPressure2"));
                r.setDescription(resultSet.getString("description"));

                return r;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
*/
    public void delete(String email) {

        String sql = "DELETE FROM record where email = '"+ email + "'";
        try {
            Connection conn = this.conn;
            Statement statement = conn.createStatement();
            int r =  statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
