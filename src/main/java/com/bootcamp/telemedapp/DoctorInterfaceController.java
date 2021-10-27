package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;


@Controller
public class DoctorInterfaceController {

    @Autowired
    PatientMemoryManager patientMemoryManager;

    @Autowired
    RecordMemoryManager databaseManager;
    String currMail;

    @PostConstruct
    public void init1() {
        patientMemoryManager.getpatientList().add(new Patient("Pero", "Perić", "pero.peric@gmail.com", "22.10.1984"));
        patientMemoryManager.getpatientList().add(new Patient("Ivo", "Ivić", "ivi.ivic@gmail.com", "13.02.1978"));    }

    @GetMapping("/telemedapp/add_patient")
    String save(@RequestParam String name,
                @RequestParam String surname,
                @RequestParam String email,
                @RequestParam String date){
        Patient patient = new Patient(name,surname,email,date);
        patientMemoryManager.getpatientList().add(patient);
       System.out.println("You entered:\nEmail: " + name + "\n" +
                "Systolic pressure: " + surname + "\n" +
                "Diastolic pressure: " + email + "\n" +
                "Date: " + date);
        currMail = email;

        return "redirect:/telemedapp/list_patients";
    }

    @GetMapping("/telemed_doctor/")
    String root() {
        return "redirect:/telemedapp/list_patients";
    }


    @GetMapping("/telemedapp/list_patients")
    String listAll(Model model)  {
        model.addAttribute("patientList", patientMemoryManager.getpatientList());
        return "/telemedapp/list_patients_";
    }

    @GetMapping("/telemedapp/select_patient")

    String select(Model model, @RequestParam String email) {

        model.addAttribute("patientList", patientMemoryManager.getPatient(email));
        model.addAttribute("recordList", databaseManager.getPatientRecords(email));
        return "/telemedapp/select_patient";
    }
}
