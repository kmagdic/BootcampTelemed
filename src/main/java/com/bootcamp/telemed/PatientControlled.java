package com.bootcamp.telemed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
public class PatientControlled {

    @Autowired
    PatientMemoryManager patientMemoryManager;

    @GetMapping("/telemed/add_patient")
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

        return "redirect:/telemed/list_patients";
    }

    @GetMapping("/telemed/")
    String root() {
        return "redirect:/telemed/doctorPatient.html";
    }


    @GetMapping("/telemed/list_patients")
    String listAll(Model model)  {
        model.addAttribute("patientList", patientMemoryManager.getpatientList());
        System.out.println("asdas");
        return "/telemed/list_patients_";
    }
}
