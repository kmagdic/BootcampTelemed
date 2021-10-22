package com.bootcamp.telemedapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseManager {

    List<BloodPressureRecord> recordList = new ArrayList<BloodPressureRecord>();

    public List<BloodPressureRecord> getRecordList() {
        return recordList;
    }

    public List<BloodPressureRecord> getPatientRecords(String currEmail) {
        List<BloodPressureRecord> emailList = new ArrayList<BloodPressureRecord>();
        for (BloodPressureRecord record : recordList) {
            if (record.getEmail().equals(currEmail))
                emailList.add(record);
        }
        return emailList;
    }
}