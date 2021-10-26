package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.model.BloodPressureRecord;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

@Service
public class RecordMemoryManager {

    List<BloodPressureRecord> recordList = new ArrayList<BloodPressureRecord>();

    public List<BloodPressureRecord> getRecordList() {
        return recordList;
    }

    public List<BloodPressureRecord> getPatientRecords(String currEmail) {
        List<BloodPressureRecord> emailList = new ArrayList<BloodPressureRecord>();
        for (BloodPressureRecord record : recordList) {
            if (record.getEmail().equals(currEmail))
                emailList.add(record);
            emailList.sort(new Comparator<BloodPressureRecord>() {
                @Override
                public int compare(BloodPressureRecord time1, BloodPressureRecord time2) {
                    return time2.getTimestamp().compareTo(time1.getTimestamp());
                }
            });
        }
        return emailList;
    }
}