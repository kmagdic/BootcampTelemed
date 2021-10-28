package com.bootcamp;

import com.bootcamp.telemedapp.PatientDBManager;
import com.bootcamp.telemedapp.RecordDBManager;
import com.bootcamp.telemedapp.model.BloodPressureRecord;
import com.bootcamp.telemedapp.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BootcampTelemedApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testPatientDBManager() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		Patient p1 = new Patient("Pero","Peric", "pero@peric.com", sdf.parse("01.01.2000"));
		//Patient p2 = new Patient("Ante","Antic", "ante@antic.com", sdf.parse ("02.02.2000"));
		//Patient p3 = new Patient("Marko","Markic", "marko@markic.com", sdf.parse ("03.03.3000"));


		PatientDBManager dbManager = new PatientDBManager();
		dbManager.makeConnection();
		dbManager.addPatient(p1);
		//dbManager.addPatient(p2);
		//dbManager.addPatient(p3);

		Patient db_p1 = dbManager.getPatientByEmail("pero@peric.com");

		assertThat(p1.getName().equals(db_p1.getName()));
		dbManager.delete(db_p1);

	}

	@Test
	void testDBRecord() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		BloodPressureRecord r1 = new BloodPressureRecord( sdf.parse ("01.01.2000"), "pero@peric.com", "100", "120", "test1"  );
		//BloodPressureRecord r2 = new BloodPressureRecord( sdf.parse ("02.02.2002"), "pero@peric.com", "105", "125", "test2"  );
		//BloodPressureRecord r3 = new BloodPressureRecord( sdf.parse ("03.03.2003"), "pero@peric.com", "110", "130", "test3"  );

/*		BloodPressureRecord r4 = new BloodPressureRecord( sdf.parse ("01.01.2000"), "ante@antic.com", "100", "120", "test4"  );
		BloodPressureRecord r5 = new BloodPressureRecord( sdf.parse ("02.02.2002"), "ante@antic.com", "105", "125", "test5"  );
		BloodPressureRecord r6 = new BloodPressureRecord( sdf.parse ("03.03.2003"), "ante@antic.com", "110", "130", "test6"  );

		BloodPressureRecord r7 = new BloodPressureRecord( sdf.parse ("01.01.2000"), "ante@antic.com", "100", "120", "test7"  );
		BloodPressureRecord r8 = new BloodPressureRecord( sdf.parse ("02.02.2002"), "ante@antic.com", "105", "125", "test8"  );
		BloodPressureRecord r9 = new BloodPressureRecord( sdf.parse ("03.03.2003"), "ante@antic.com", "110", "130", "test9"  );
*/
		RecordDBManager recordManager = new RecordDBManager();

		recordManager.addRecord(r1);
		//recordManager.addRecord(r2);
		//recordManager.addRecord(r3);

/*		recordManager.addRecord(r4);
		recordManager.addRecord(r5);
		recordManager.addRecord(r6);

		recordManager.addRecord(r7);
		recordManager.addRecord(r8);
		recordManager.addRecord(r9);
*/
		List<BloodPressureRecord> db_rList = recordManager.getPatientRecords("pero@peric.com");

		assertThat(r1.getDescription().equals(db_rList.get(0).getDescription()));
		recordManager.delete(r1.getEmail());

	}
}
