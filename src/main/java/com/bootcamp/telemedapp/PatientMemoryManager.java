
package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMemoryManager {

    List<Patient> patientList  = new ArrayList<Patient>();

    public List<Patient> getpatientList() {
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

}
