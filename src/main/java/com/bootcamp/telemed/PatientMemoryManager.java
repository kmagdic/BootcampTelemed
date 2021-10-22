
package com.bootcamp.telemed;

        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;

@Service
public class PatientMemoryManager {

    List<Patient> patientList  = new ArrayList<Patient>();

    public List<Patient> getpatientList() {
        return patientList;
    }
}
