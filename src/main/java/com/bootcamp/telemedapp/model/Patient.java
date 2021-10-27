package com.bootcamp.telemedapp.model;

import java.util.Date;

public class Patient {
    private String name;
    private String surname;
    private String email;
    private Date dateOfBirth;

    public Patient() {
    }

    public Patient(String name, String surname, String email, Date date) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = date;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
