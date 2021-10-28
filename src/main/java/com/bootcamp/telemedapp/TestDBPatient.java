package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.PatientDBManager;
import com.bootcamp.telemedapp.model.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDBPatient {


    public static void createInitialData() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Patient p1 = new Patient("Pero","Peric", "pero@peric.com", sdf.parse("01.01.2000"));
        Patient p2 = new Patient("Ante","Antic", "ante@antic.com", sdf.parse ("02.02.2000"));
        Patient p3 = new Patient("Marko","Markic", "marko@markic.com", sdf.parse ("03.03.3000"));


        PatientDBManager newconnection = new PatientDBManager();
        newconnection.makeConnection();
        newconnection.addPatient(p1);
        newconnection.addPatient(p2);
        newconnection.addPatient(p3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}