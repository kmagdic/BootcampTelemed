package com.bootcamp.telemedapp;

import com.bootcamp.telemedapp.RecordDBManager;
import com.bootcamp.telemedapp.model.BloodPressureRecord;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDBRecord {

    public static void createInitalData() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        BloodPressureRecord r1 = new BloodPressureRecord( sdf.parse ("01.01.2000"), "pero@peric.com", "100", "120", "test1"  );
        BloodPressureRecord r2 = new BloodPressureRecord( sdf.parse ("02.02.2002"), "pero@peric.com", "105", "125", "test2"  );
        BloodPressureRecord r3 = new BloodPressureRecord( sdf.parse ("03.03.2003"), "pero@peric.com", "110", "130", "test3"  );

        BloodPressureRecord r4 = new BloodPressureRecord( sdf.parse ("01.01.2000"), "ante@antic.com", "100", "120", "test4"  );
        BloodPressureRecord r5 = new BloodPressureRecord( sdf.parse ("02.02.2002"), "ante@antic.com", "105", "125", "test5"  );
        BloodPressureRecord r6 = new BloodPressureRecord( sdf.parse ("03.03.2003"), "ante@antic.com", "110", "130", "test6"  );

        BloodPressureRecord r7 = new BloodPressureRecord( sdf.parse ("01.01.2000"), "marko@markic.com", "100", "120", "test7"  );
        BloodPressureRecord r8 = new BloodPressureRecord( sdf.parse ("02.02.2002"), "marko@markic.com", "105", "125", "test8"  );
        BloodPressureRecord r9 = new BloodPressureRecord( sdf.parse ("03.03.2003"), "marko@markic.com", "110", "130", "test9"  );

        RecordDBManager newconnection = new RecordDBManager();

        newconnection.addRecord(r1);
        newconnection.addRecord(r2);
        newconnection.addRecord(r3);

        newconnection.addRecord(r4);
        newconnection.addRecord(r5);
        newconnection.addRecord(r6);

        newconnection.addRecord(r7);
        newconnection.addRecord(r8);
        newconnection.addRecord(r9);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);
        System.out.println(r7);
        System.out.println(r8);
        System.out.println(r9);
    }

}
