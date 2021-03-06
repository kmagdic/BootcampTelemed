package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;


@Controller
public class DoctorInterfaceController {

    @Autowired
    PatientDBManager patientManager;

    @Autowired
    RecordDBManager databaseManager;

    @PostConstruct
    public void init1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        //patientManager.getPatientList().add(new Patient("Pero", "Perić", "pero.peric@gmail.com", sdf.parse("22.10.1984")));
        //patientManager.getPatientList().add(new Patient("Ivo", "Ivić", "ivi.ivic@gmail.com", sdf.parse("13.02.1978")));
    }

    @GetMapping("/telemedapp/add_patient")
    String save(@RequestParam String name,
                @RequestParam String surname,
                @RequestParam String email,
                @RequestParam String date){

        // parsing date
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            System.out.println("Date is not in correct format: " + date);
        }
        if (patientManager.isEmailInDatabase(email)) {
            return "/telemedapp/email_yesindb.html";
        } else {

            Patient patient = new Patient(name, surname, email, date1);
            patientManager.getPatientList().add(patient);

            // PatientDBManager
            PatientDBManager newconnection = new PatientDBManager();
            newconnection.makeConnection();
            newconnection.addPatient(patient);

            System.out.println("You entered:\nEmail: " + name + "\n" +
                    "Systolic pressure: " + surname + "\n" +
                    "Diastolic pressure: " + email + "\n" +
                    "Date: " + date);
            newconnection.closeConnection();

            return "redirect:/telemedapp/list_patients";
        }
    }

    @GetMapping("/telemed_doctor/")
    String root() {
        return "redirect:/telemedapp/list_patients";
    }


    @GetMapping("/telemedapp/list_patients")
    String listAll(Model model)  {
        model.addAttribute("patientList", patientManager.getPatientList());
        return "/telemedapp/list_patients_";
    }

    @GetMapping("/telemedapp/select_patient")

    String select(Model model, @RequestParam String email) {

        model.addAttribute("patient", patientManager.getPatientByEmail(email));
        model.addAttribute("recordList", databaseManager.getPatientRecords(email));
        return "/telemedapp/select_patient";
    }
    @GetMapping("/telemedapp/delete_patient")
    String delete(Model model, @RequestParam String email) {
        model.addAttribute("patient", patientManager.delete(email));
        return "/telemedapp/list_patients";
    }
}
