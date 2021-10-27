package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DoctorInterfaceController {

    @Autowired
    PatientMemoryManager patientMemoryManager;
    RecordMemoryManager databaseManager;
    String currMail;


    @GetMapping("/telemedapp/add_patient")
    String save(@RequestParam String name,
                @RequestParam String surname,
                @RequestParam String email,
                @RequestParam String date){
        if (patientMemoryManager.findPatient(email)) {
            return "/telemedapp/email_yesindb.html";
        }else {
            Patient patient = new Patient(name, surname, email, date);
            patientMemoryManager.getpatientList().add(patient);
            System.out.println("You entered:\nEmail: " + name + "\n" +
                    "Systolic pressure: " + surname + "\n" +
                    "Diastolic pressure: " + email + "\n" +
                    "Date: " + date);
            currMail = email;

            return "redirect:/telemedapp/list_patients";
        }
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
