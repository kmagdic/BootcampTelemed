package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.BloodPressureRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class PatientInterfaceController {

    @Autowired
    RecordMemoryManager databaseManager;
    String currMail;


    @PostConstruct
    public void init() {
        databaseManager.getRecordList().add(
                new BloodPressureRecord(new Date(), "email1", "Prvi tlak", "Drugi tlak", "Opis stanja"));
    }

    @GetMapping("/telemedapp/")
    String root() {
        return "redirect:/telemedapp/enter_data.html";
    }

    @GetMapping("/telemedapp/save_data")
    String save (
            @RequestParam String email,
            @RequestParam String bloodPressure1,
            @RequestParam String bloodPressure2,
            @RequestParam String description,
            HttpServletResponse response) throws IOException {
        System.out.println("You entered:\nEmail: " + email + "\n" +
                "Systolic pressure: " + bloodPressure1 + "\n" +
                "Diastolic pressure: " + bloodPressure2 + "\n" +
                "State: " + description);

        currMail = email;

        BloodPressureRecord record = new BloodPressureRecord(new Date(), email,bloodPressure1,bloodPressure2,description);
        databaseManager.getRecordList().add(record);

        return "redirect:/telemedapp/list_data";
    }

    @GetMapping("/telemedapp/list_data")
    String listAll (Model model) throws IOException {

        model.addAttribute("mail", currMail);
        model.addAttribute("recordList", databaseManager.getPatientRecords(currMail));
        return "/telemedapp/list_data";

    }
}