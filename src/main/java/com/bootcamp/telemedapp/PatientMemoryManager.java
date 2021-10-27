
package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.Patient;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMemoryManager {

    List<Patient> patientList = new ArrayList<Patient>();

    public List<Patient> getPatientList() {
        return patientList;
    }

    public List<Patient> getPatient(String currEmail) {
        List<Patient> patientRecord = new ArrayList<Patient>();
        for (Patient record : patientList) {
            if (record.getEmail().equals(currEmail))
                patientRecord.add(record);
        }
        return patientRecord;
    }

    public boolean findPatient(String email) {
        boolean query = false;
        for (Patient p : patientList) {
            if (p.getEmail().equals(email)) {
                return true;
            }
        }
        return query;
    }

    public void alertBox(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    public Patient getPatientByEmail(String currMail) {
        for (Patient p : patientList) {
            if (p.getEmail().equals(currMail)) {
                return p;
            }
        }
        return null;
    }
}
