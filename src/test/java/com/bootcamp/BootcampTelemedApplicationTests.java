package com.bootcamp;

import com.bootcamp.telemedapp.PatientDBManager;
import com.bootcamp.telemedapp.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
