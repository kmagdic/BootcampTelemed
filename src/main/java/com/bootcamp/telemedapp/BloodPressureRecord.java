package com.bootcamp.telemedapp;

import java.util.Date;

public class BloodPressureRecord {
    private Date timestamp;
    private String email;
    private String bloodPressure1;
    private String bloodPressure2;
    private String description;


    public BloodPressureRecord() {
    }

    public BloodPressureRecord(Date timestamp, String email, String bloodPressure1, String bloodPressure2, String description) {
        this.timestamp = timestamp;
        this.email = email;
        this.bloodPressure1 = bloodPressure1;
        this.bloodPressure2 = bloodPressure2;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodPressure1() {
        return bloodPressure1;
    }

    public void setBloodPressure1(String bloodPressure1) {
        this.bloodPressure1 = bloodPressure1;
    }

    public String getBloodPressure2() {
        return bloodPressure2;
    }

    public void setBloodPressure2(String bloodPressure2) {
        this.bloodPressure2 = bloodPressure2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
